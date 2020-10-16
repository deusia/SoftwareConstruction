package sc.ch3;

public class Student {
    private static Exercise exercise;


    public Student() {

    }

    public static void printExercise() {
        int i = 1;
        while (exercise.hasNext()) {
            System.out.print("(" + i + ")" + exercise.next().toString3());

            if (i % 5 == 0) {
                System.out.println();
            } else {
                System.out.print("\t");
            }
            exercise.setIndex(i++);

        }
        System.out.println();
        exercise.getExercise().clear();
        exercise.setIndex(0);

    }

    public static void main(String[] args) {

        exercise = new Exercise();
        System.out.println("--------------------------如下是混合运算习题----------------------");
        exercise.generateExercise();
        printExercise();
        System.out.println("--------------------------如下是加法运算习题----------------------");
        exercise.generateAddExercise();
        printExercise();
        System.out.println("--------------------------如下是减法运算习题----------------------");
        exercise.generateSubExercise();
        printExercise();
    }

}
