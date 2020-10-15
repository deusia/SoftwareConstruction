package sc.ch3;

import java.util.ArrayList;

public class Student {
    private static Exercise exercise;


    public Student() {

    }

    public static void printExercise() {
        int i = 0;
        while (exercise.hasNext()) {
            System.out.print("(" + (i + 1) + ")" + exercise.next().toString3());
            exercise.setIndex(i++);

            if (i % 5 == 0) {
                System.out.println();
            } else {
                System.out.print("\t");
            }
        }
        System.out.println();
        exercise.getExercise().clear();

    }

    public static void main(String[] args) {

        exercise = new Exercise();
        System.out.println("--------------------------�����ǻ������ϰ��----------------------");
        exercise.generateExercise();
        exercise.printExercise();
        System.out.println("--------------------------�����Ǽӷ�����ϰ��----------------------");
        exercise.generateAddExercise();
        exercise.printExercise();
        System.out.println("--------------------------�����Ǽ�������ϰ��----------------------");
        exercise.generateSubExercise();
        exercise.printExercise();
    }

}
