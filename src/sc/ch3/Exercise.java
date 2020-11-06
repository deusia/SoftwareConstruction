/**
 * 
 */
package sc.ch3;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Administrator
 *
 */
public class Exercise {

	private  int COUNT = 50;
	private  int index =0;//标识习题中当前算式的序号
	private ArrayList<Equation> exercise = null;
	
	public int getCOUNT() {
		return COUNT;
	}

	public void setCOUNT(int cOUNT) {
		COUNT = cOUNT;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public ArrayList<Equation> getExercise() {
		return exercise;
	}

	public void setExercise(ArrayList<Equation> exercise) {
		this.exercise = exercise;
	}

	public Exercise() {
		index = 0;
		exercise = new ArrayList<Equation>();
	}
	
	public Exercise (int count)//构造任意数量的习题
	{
		this.setCOUNT(count);
		index = 0;
		exercise = new ArrayList<Equation>();
	}
	
	//判断一个算是是否已经存在
	public boolean occursIn(Equation e)
	{
		boolean b = false;
		for(Equation equation: exercise){
			if(equation.isEqual(e)){
				b = true;
				break;
			}
		}
		return b;
	}
	
	//构造混合习题
	public void generateExercise(){
		int i = 0;//表示当前习题中构造习题的数量
		Random r = new Random();
		while(i<COUNT){
			Equation e;
			if (r.nextInt(2)==1){
				e= new AddEquation();
			}else{
				e = new SubEquation();
			}
			if(! occursIn(e))
			{
				exercise.add(e);
				i++;
			}
		}
	}
	
	//生成加法习题
	public void generateAddExercise(){
		int  i = 0;
		while(i<COUNT){
			Equation e = new AddEquation();
			if(! occursIn(e))
			{
				exercise.add(e);
				i++;
			}
		}
		
	}
	//生成见法习题
	public void generateSubExercise(){
		int  i = 0;
		while(i<COUNT){
			Equation e = new SubEquation();
			if(! occursIn(e))
			{
				exercise.add(e);
				i++;
			}
		}
		
	}
	//输出习题
	public void printExercise(){
		int i = 0;
		for(Equation e:exercise){
			i++;//表示当前已经输出的算式
			System.out.print("("+i+")"+e.toString());
			if(i%5==0)
			{
				System.out.println();
			}
			else
			{
				System.out.print("\t");
			}
		}
	}
   //构造习题类中遍历算式的方法
	public boolean hasNext()
	{
		return index<exercise.size();
	}
	//获取下一个算式
	public Equation next(){
		if(index <exercise.size()){
			return exercise.get(index++);
		}else
		{
			return null;
		}
	}
	
	public boolean add(Equation e){//变相的叠加器，把新的算式加入到习题
		if(index <COUNT){
			exercise.add(e);
			index++;
			return true;
		}else{
			return false;
			}
	}
	
	public int size(){return exercise.size();}
}
