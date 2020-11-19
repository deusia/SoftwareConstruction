package sc.ch5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class Answer {

    private ArrayList<Integer> answer;

    public ArrayList<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList<Integer> answer) {
        this.answer = answer;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private int index;

    public Answer() {
        // TODO 自动生成的构造函数存根
        answer = new ArrayList<Integer>();
        index = 0;
    }

    public void writeAnswerToFile(String fileName) {
        File exFile = new File(fileName);
        Writer out = null;//初始化输出流
        try {
            out = new FileWriter(exFile, true);
            for (Integer i : answer) {
                out.write(i + ",");
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readAnswerFromFile(String fileName) {
        File exFile = new File(fileName);
        String a;
        Scanner in = null;
        answer.clear();
        try {
            in = new Scanner(exFile);
            in.useDelimiter(",");
            while (in.hasNext()) {
                a = in.next().replaceAll("\\s", "");
                answer.add(Integer.parseInt(a));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }

    public void scanAnswerFromKeyboard(int count) {
        Scanner sc = new Scanner(System.in);//初始化输入流，从键盘输入
        answer.clear();
        System.out.println("请按照题目序号一次输入答案后回车");
        for (int i = 1; i <= count; i++) {
            System.out.print("(" + i + ")");
            answer.add(sc.nextInt());//通过输入流从键盘读取整数加入到答案的数据集
        }
        sc.close();
    }

    public Boolean add(int a) {
        return answer.add(a);
    }

    public Boolean hasNext() {
        return index < answer.size();
    }

    public int next() {
        if (index < answer.size()) {
            return answer.get(index++);
        } else {
            return -1;
        }
    }

    //重置答案数据集中索引的序号
    public void reset() {
        index = 0;
    }

    public int get(int index) {
        return answer.get(index);
    }

    public void set(int index, int x) {
        answer.set(index, x);
    }
}

