package sc.ch5;

import sc.ch3.Exercise;
import sc.ch3.Student;

import java.util.Scanner;

public class CommandUI {
    static String ui1[] = {"退出", "在线练习", "批量习题", "批改习题", "", ""};
    static String ui2[][] = {
            {},
            {"返回上一级菜单", "加法", "减法", "混合"},
            {"返回上一级菜单", "加法", "减法", "混合"},
            {},
            {},
            {},
    };

    static Scanner sc = new Scanner(System.in);

    public CommandUI() {

    }

    public static void main(String[] args) {
        int command1, command2;
        boolean exit = false;
        while (!exit) {
            print1();
            command1 = sc.nextInt();
            switch (command1) {
                case 1:
                    print2(command1);           //打印二级菜单
                    command2 = sc.nextInt();
                    command1_1(command2);       //处理用户选择二级菜单序号的程序操作
                    break;
                case 2:
                    print2(command1);
                    command2 = sc.nextInt();
//                    command1_2(command2);       //处理用户选择“批量习题”二级菜单序号的程序操作
                    break;
                case 3:

                case 0:

            }
        }
    }


    //打印一级菜单
    public static void print1() {
        System.out.println("口算练习-功能列表");
        for (int i = 0; i < ui1.length; i++) {
            if (ui1[i] != null && ui1[i].length() > 0) {
                System.out.println("" + i + " " + ui1[i]);
            }
        }
        System.out.println("0 " + ui1[0]);
        System.out.println("请选择功能序号");
    }

    public static void print2(int index) {
        System.out.println("您选择了功能：" + index + ui1[index]);
        if (ui2[index] != null && ui2[index].length > 0) {
            System.out.println("请选择习题的类型：");
            for (int i = 1; i < ui2[index].length; i++) {
                System.out.println("" + i + " " + ui2[index][i]);
            }
            System.out.println("0 " + ui2[index][0]);
        }
    }

    //选择以及菜单在线习题进入二级菜单，接收输入之后的时候的响应处理，处理用户选择二级菜单序号后
    public static void command1_1(int index) {
        int count;
        System.out.println("您选择了: " + index + ui2[1][index]);
        if (index == 0) {
            return;
        }
        System.out.println("请输入算是数量：");
        count = sc.nextInt();
        Exercise ex = new Exercise(count);
        if (index == 1) {
            ex.generateAddExercise();
        } else if (index == 2) {
            ex.generateSubExercise();
        } else {
            ex.generateExercise();
        }
        Student s=new Student();
        s.setSc(sc);
        s.setExercise(ex);
        s.practiceOneByOne();
    }
}
