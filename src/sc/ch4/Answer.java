package sc.ch4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class Answer {
    private ArrayList<Integer> answer;
    private int index;

    public Answer() {
        answer = new ArrayList<Integer>();
        index = 0;
    }

    public void writeAnswerToFile(String fileName) {
        File exFile = new File(fileName);
        Writer out = null;
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
        Scanner sc = new Scanner(System.in);//初始化输入流从键盘输入
        answer.clear();
        System.out.println("请按照题目序号依次输入答案后回车");
        for (int i = 1; i <= count; i++) {
            System.out.print("(" + i + ")");
            answer.add(sc.nextInt());//通过输入流从键盘读取整数加入到答案的数据集
        }
        sc.close();
    }

    public boolean add(int a) {
        return answer.add(a);
    }

    public boolean hashNext() {
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
    public void reset() { index = 0; }

    //按照题目的序号获取答案
    public int get(int index) { return answer.get(index); }

    //按照题目的序号设置答案
    public int set(int index, int x) { return answer.set(index, x); }


}
