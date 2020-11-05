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

    //�ж�һ�������Ƿ��ڵ�ǰϰ���д���
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

    //������ϰ��ķ���
    public void generateExercise() {
        int i = 0;//i��ʾ��ǰϰ�����Ѿ����������
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
        int i = 0;//i��ʾ��ǰϰ�����Ѿ����������

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
        int i = 0;//i��ʾ��ǰϰ�����Ѿ����������

        while (i < count) {
            Equation e;
            e = new SubEquation();
            if (!occursIn(e)) {
                exercise.add(e);
                i++;
            }
        }
    }


    //���ϰ��
    public void printExercise() {
        int i = 0;
        for (Equation e : exercise) {
            i++;//��ʾ��ǰ�Ѿ����������
            System.out.print("(" + i + ")" + e.toString3());
            if (i % 5 == 0) {
                System.out.println();
            } else {
                System.out.print("\t");
            }
        }
        exercise.clear();
    }

    //����ϰ�����б�����ʽ�ķ���
    public boolean hasNext() {
        return index < exercise.size();
    }

    //��ȡ��һ�����ǵķ���
    public Equation next() {
        if (index < exercise.size()) {
            return exercise.get(index);
        } else {
            return null;
        }
    }
    public boolean add(Equation e){
        if (index<count){
            exercise.add(e);
            index++;
            return true;
        }else {
            return false;
        }
    }
    public int size(){
        return exercise.size();
    }
}
