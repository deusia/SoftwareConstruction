package sc.ch4;

import sc.ch3.AddEquation;
import sc.ch3.Exercise;
import sc.ch3.SubEquation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class ExerciseFileDAO {
    public ExerciseFileDAO() {

    }

    public void writeExerciseToFile(Exercise e, String fileName) {
        //定义文件对象
        File exFile = new File(fileName);
        //定义文件输出流
        Writer out;

        try {
            //追加输出流信息到文件的尾部
            out = new FileWriter(exFile, true);

            while (e.hasNext()) {
                out.write(e.next().toString() + ",");
            }

        } catch (IOException ex) {
            System.out.println("Error" + ex);
        }

    }

    public Exercise readExerciseFromFile(String fileName) {
        File exFile = new File(fileName);
        Exercise exercise = new Exercise();
        String equation;
        //初始化输入流
        Scanner in = null;

        try {
            //初始化输入对象
            in = new Scanner(exFile);
            //定义输入流的分隔符为逗号
            in.useDelimiter(",");

            while (in.hasNext()) {
                equation = in.next().replaceAll("\\s", "");

                if (equation.contains("+")) {
                    exercise.add(new AddEquation(equation));
                } else {
                    exercise.add(new SubEquation(equation));
                }
            }
        } catch (IOException e) {
            //在命令行打印异常信息在程序中出错的位置
            e.printStackTrace();
        }finally {
            in.close();
        }

        return exercise;
    }
}
