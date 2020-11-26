package sc.ch3;

import java.util.Random;

public abstract class Equation {
	
	private final int MAX = 100;
	private final int MIN = 0;
//	private final int COUNT = 50;
	private int left,right,result;
	private char op;
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public char getOp() {
		return op;
	}
	public void setOp(char op) {
		this.op = op;
	}
	
	public Equation(){
		
	}
	//生成随机整数的方法
	private int generateRandom(int min,int max)
	{
		Random r = new Random();
		return r.nextInt(max-min+1)+min;
	}
	//判断运算结果在某个范围内的方法
	private boolean isBetween (int value,int min,int max)
	{
		return value>=min&&value<=max;
	}
	protected abstract int calculate();
	
	//判断两个算式是否相等
	public boolean isEqual( Equation e)
	{
		boolean b =false;
		if(e.getOp()!=this.getOp())
		{
			b=false;
		}else
		{
			b=e.getLeft()==this.getLeft()&&e.getRight()==this.getRight();
		}
		return b;
	}
	//将算式转换字符串类型∶25+31
	public 	String toString()
	{
		return ""+this.getLeft()+this.getOp()+this.getRight();
	}
	//将算式转换字符串类型∶25+31=
	public 	String toString2()
	{
		return ""+this.getLeft()+this.getOp()+this.getRight()+"=";
	}

	//将算式转换字符串类型∶25+31=56
	public 	String toString3()
	{
		return ""+this.getLeft()+this.getOp()+this.getRight()+"="+this.getResult();
	}
	public void generateEquation(char op)//生成一个算是方法的公共部分操作
	{
		do{
			left = generateRandom(MIN,MAX);
			right = generateRandom(MIN,MAX);
			result = calculate(); 
		}while(! isBetween(result,MIN,MAX));
			
		this .setOp(op);
	}


}
