package sc.ch5;

import sc.ch3.Exercise;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Check {

	private int count;
	private int right;
	private int wrong;
	
	
	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getRight() {
		return right;
	}


	public void setRight(int right) {
		this.right = right;
	}


	public int getWrong() {
		return wrong;
	}


	public void setWrong(int wrong) {
		this.wrong = wrong;
	}


	public Check() {
		// TODO 自动生成的构造函数存根
		right=0;
		wrong=0;
				
	}
	
	public void check(Exercise ex, Answer an){
		int wrong=0,right=0;
		count =ex.size();
		ex.setIndex(0);
		an.reset();
		
		while(ex.hasNext()){
			if(ex.next().getResult()==an.next()){
				right++;
			}else{wrong++;}
		}
		//设置批改结果
		setRight(right);
		setWrong(wrong);
	}
	
	public void writeCheckToFile(String fileName){
		File exFile=new File(fileName);
		Writer out;
		try{
			out=new FileWriter(exFile,true);
			out.write("算式总数："+count+";\r\n");
			out.write("正确总数："+count+";\r\n");
			out.write("错误总数："+count+";\r\n");
			out.flush();
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void printCheck(){
		System.out.println("本次练习批改结果是:");
		System.out.println("算式总数："+count);
		System.out.println("正确总数："+right);
		System.out.println("错误总数："+wrong);}

}
