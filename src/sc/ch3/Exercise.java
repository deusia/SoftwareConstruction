package sc.ch3;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Random;

public class Exercise {
    private int count = 50;
    private int index;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public AbstractList<Equation> getExercise() {
        return exercise;
    }

    public void setExercise(AbstractList<Equation> exercise) {
        this.exercise = exercise;
    }

    private AbstractList<Equation> exercise = null;

    public Exercise() {
        index = 0;
        exercise = new ArrayList<Equation>();

    }

    public Exercise(int count) {
        this.setCount(count);
        index = 0;
        exercise = new ArrayList<Equation>();
    }

    //判断一个算是是否在当前习题中存在
    public boolean occursIn(Equation e) {
        boolean b = false;
        for (Equation equation : exercise) {
            if (equation.isEqual(e)) {
                b = true;
                break;
            }
        }
        return b;
    }

    //构造混合习题的方法
    public void generateExercise() {
        int i = 0;//i表示当前习题中已经构造的数量
        Random r = new Random();

        while (i < count) {
            Equation e;
            if (r.nextInt(2) == 1) {
                e = new AddEquation();
            } else {
                e = new SubEquation();
            }

            if (!occursIn(e)) {
                exercise.add(e);
                i++;
            }
        }
    }

    public void generateAddExercise() {
        int i = 0;//i表示当前习题中已经构造的数量

        while (i < count) {
            Equation e;
                e = new AddEquation();
            if (!occursIn(e)) {
                exercise.add(e);
                i++;
            }
        }
    }

    public void generateSubExercise() {
        int i = 0;//i表示当前习题中已经构造的数量

        while (i < count) {
            Equation e;
            e = new SubEquation();
            if (!occursIn(e)) {
                exercise.add(e);
                i++;
            }
        }
    }


    //输出习题
    public void printExercise() {
        int i = 0;
        for (Equation e : exercise) {
            i++;//表示当前已经输出的算是
            System.out.print("(" + i + ")" + e.toString3());
            if (i % 5 == 0) {
                System.out.println();
            } else {
                System.out.print("\t");
            }
        }
        exercise.clear();
    }

    //构造习题类中遍历算式的方法
    public boolean hasNext() {

        return index < exercise.size();
    }

    //获取下一个算是的方法
    public Equation next() {
        if (index < exercise.size()) {
            return exercise.get(index);
        } else {
            return null;
        }
    }
}
