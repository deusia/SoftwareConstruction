package sc.ch4;

import sc.ch3.Exercise;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Scanner;

public class Parents {
    private String path;
    private String[] fileName;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String[] getFileName() {
        return fileName;
    }

    public void setFileName(String[] fileName) {
        this.fileName = fileName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    private int count;
    private int n;
    private Scanner sc;
    private ExerciseFileDAO eDAO;


    public Parents() {
        path = "D://csv/";

        File file = new File(path);//抽象定义目录的对象
        if (!file.exists()) {
            file.mkdirs();//如果文件路径不存在，就创建文件
        }
        eDAO = new ExerciseFileDAO();
    }

    public Parents(int count, int n) {
        this();//调用无参数构造函数
        this.count = count;
        this.n = n;
    }

    public void writeExerciseToFiles() {
        Exercise ex = new Exercise(count);
        for (int i = 0; i < n; i++) {
            String fileName = "D://csv/exercise_mix_" + count + "_" + i + ".csv";
            ex.generateExercise();
            eDAO.writeExerciseToFile(ex, fileName);
        }
    }


    public void writeAddExerciseToFiles() {
        Exercise ex = new Exercise(count);
        for (int i = 0; i < n; i++) {
            String fileName = "D://csv/exercise_add_" + count + "_" + i + ".csv";
            ex.generateAddExercise();
            eDAO.writeExerciseToFile(ex, fileName);
        }
    }

    public void writeSubExerciseToFiles() {
        Exercise ex = new Exercise(count);
        for (int i = 0; i < n; i++) {
            String fileName = "D://csv/exercise_sub_" + count + "_" + i + ".csv";
            ex.generateSubExercise();
            eDAO.writeExerciseToFile(ex, fileName);
        }
    }

    //过滤显示文件名,展示符合过滤条件的文件列表
    private void setFileName() {
        File file = new File(path);
        FileFilter filter = new FileFilter();
        fileName = file.list(filter);//根据过滤器选择符合条件的文件，返回文件名到String数组
    }

    public void check() {
        setFileName();//过滤批改的文件列表
        int i = 1;
        if (fileName.length <= 0) {
            System.out.println("***********没有需要批改的习题！************");
            return;
        }
        for (String s : fileName) {
            System.out.println(i++ + ":" + s);
        }
        System.out.println("请选择需要的批改的习题序号：");
        int index = sc.nextInt();
        Exercise exercise = new Exercise(0);
        exercise = eDAO.readExerciseFromFile(path + fileName[index - 1]);
        Answer answer = new Answer();

        int n = exercise.size();
        System.out.println("*************请根据序号提示依次输入答案后回车*********");
        for (i = 0; i < n; i++) {
            System.out.print("(" + (i + 1) + ")");
            answer.add(sc.nextInt());
        }

        answer.writeAnswerToFile(path + fileName[index - 1].replaceAll("exercise", "answer"));
        Check check = new Check();
        check.check(exercise, answer);
        check.writeCheckToFile(path + fileName[index - 1].replaceAll("exercise", "answer"));
        check.printCheck();
    }

    class FileFilter implements FilenameFilter {
        public FileFilter() {

        }

        public boolean accept(File dir, String name) {
            return name.matches("[e][x][e][r][c][i][s][e]\\w*[.][c][s][v]");
        }
    }
}
