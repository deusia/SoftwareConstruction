/**
 * 
 */
package sc.ch4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import sc.ch3.AddEquation;
import sc.ch3.Exercise;
import sc.ch3.SubEquation;

/**
 * @author Administrator
 *
 */
public class ExerciseFileDAO {

	/**
	 * 
	 */
	public ExerciseFileDAO() {
		// TODO 自动生成的构造函数存根
	}

	public void writeExerciseToFile(Exercise e, String filename){
		File exFile =new File(filename);//定义文件对象
		Writer out;//定义文件的输出流
		
		try{
			out =new FileWriter(exFile,true);//追加输出流的信息到文件的尾部
		    while(e.hasNext()){out.write(e.next().toString()+',');}
		}catch(IOException ex){
			System.out.println("Error"+ex);
		}
	}
	
	public Exercise readExerciseFromFile(String fileName){
		File exFile =new File(fileName);
		Exercise exercise =new Exercise();
		String equation;
		Scanner in=null;//初始化输入流
		try{
			in=new Scanner(exFile);//初始化输入对象
			in.useDelimiter(",");//定义输入流的分隔符为逗号
			while(in.hasNext()){
				equation =in.next().replaceAll("\\s", " ");
						
			if(equation.contains("+")){
				exercise.add(new AddEquation(equation));
			}
			else{exercise.add(new SubEquation(equation));}
			}
		}catch(IOException e){
			e.printStackTrace();//在命令行打印异常信息在程序中出错的位置
		}finally{
			in.close();
		}
		
	
		return exercise;
	}
	
}
