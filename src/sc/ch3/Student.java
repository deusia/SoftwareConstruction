/**
 * 
 */
package sc.ch3;

import java.util.Scanner;

import sc.ch4.Answer;
import sc.ch4.Check;

/**
 * @author Administrator
 *
 */
public class Student {

	private  Exercise exercise;
	private Answer answer;
	private Check check;
	private Scanner sc;
	
	public Exercise getExercise() {
		return exercise;
	}
	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}
	public Scanner getSc() {
		return sc;
	}
	public void setSc(Scanner sc) {
		this.sc = sc;
	}
	public Student() {
		// TODO 自动生成的构造函数存根
		check=new Check();
	}
	private  void printExercise(){
		int i =0;
		while(exercise.hasNext())
		{
			i++;
			System.out.print("("+i+")"+exercise.next().toString3());
			if(i%5==0)
			{
				System.out.println();
			}else{
				System.out.print("\t");
			}
		}
	}
	
	public static void main(String[] args) {
	    Student s=new Student();
		s.exercise = new Exercise();
		System.out.println("--------------------------------调用习题的打印方法----------------------------");
		s.exercise.generateExercise();
		s.printExercise();
		System.out.println("--------------------------------调用学生的打印方法----------------------------");
		s.exercise.printExercise();
		s.printExercise();
	}

	
	public void practiceOneByOne(){
		answer=new Answer();
		exercise.setIndex(0);
		int i=1;
		System.out.println("请输入答案后回车进入下一题");
		while(exercise.hasNext()){
			System.out.print("("+(i++)+")"+exercise.next().toString2());
			answer.add(sc.nextInt());//读入键盘答案
		}
		check.check(exercise, answer);
		check.printCheck();
	}
	
}
