package sc.ch4;

import sc.ch3.Exercise;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Check {
    private int count;
    private int right;
    private int wrong;

    public Check() {
        right = 0;
        wrong = 0;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getRight() {
        return right;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    public int getWrong() {
        return wrong;
    }

    public void check(Exercise ex, Answer an) {
        int wrong = 0;
        int right = 0;
        count=ex.size();
        ex.setIndex(0);
        an.reset();

        while (ex.hasNext()) {
            if (ex.next().getResult() == an.next()) {
                right++;
            }else {
                wrong++;
            }
        }
        //设置批改结果
        setRight(right);
        setWrong(wrong);
    }

    public void writeCheckToFile(String fileName){
        File exFile=new File(fileName);
        Writer out;
        try {
            out=new FileWriter(exFile,true);
            out.write("算式总数："+count+";\r\n");
            out.write("正确题数："+right+";\r\n");
            out.write("错误题数："+wrong+";\r\n");
            out.flush();
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void printCheck(){
        System.out.println("本次练习的批改结果：");
        System.out.println("\"算式总数：\"+count");
        System.out.println("\"正确题数：\"+right+\"");
        System.out.println("\"错误题数：\"+wrong+\"");
    }

}
