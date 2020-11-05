package sc.ch3;

import sc.ch4.Answer;
import sc.ch4.Check;

import java.util.Scanner;

public class Student {
    private Exercise exercise;
    private Answer answer;
    private Check check;
    private Scanner sc;

    public Answer getAnswer() {
        return answer;
    }

    public Check getCheck() {
        return check;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public Student() {

    }

//    public static void printExercise() {
//        int i = 1;
//        while (exercise.hasNext()) {
//            System.out.print("(" + i + ")" + exercise.next().toString3());
//
//            if (i % 5 == 0) {
//                System.out.println();
//            } else {
//                System.out.print("\t");
//            }
//            exercise.setIndex(i++);
//
//        }
//        System.out.println();
//        exercise.getExercise().clear();
//        exercise.setIndex(0);
//
//    }

//    public static void main(String[] args) {
//
//        exercise = new Exercise();
//        System.out.println("--------------------------如下是混合运算习题----------------------");
//        exercise.generateExercise();
//        printExercise();
//        System.out.println("--------------------------如下是加法运算习题----------------------");
//        exercise.generateAddExercise();
//        printExercise();
//        System.out.println("--------------------------如下是减法运算习题----------------------");
//        exercise.generateSubExercise();
//        printExercise();
//    }
    private void practiceOneByOne(){
        answer=new Answer();
        exercise.setIndex(0);
        int i=1;
        System.out.println("请输入答案后回车继续下一题");
        while(exercise.hasNext()){
            System.out.println("("+(i++)+")"+exercise.next().toString2());//打印习题算式
            answer.add(sc.nextInt());//读入键盘答案
        }
        check.check(exercise,answer);
        check.printCheck();
    }

    public static void main(String[] args) {
        Student s=new Student();
        s.exercise=new Exercise();
        s.exercise.getExercise();
        System.out.println("aaaaaaaaaaaaaaaaaaaa");
        s.exercise.printExercise();
    }
}
