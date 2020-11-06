package sc.ch1;


import java.util.Random;

public class Exercise {

	private class Equation {
		private int left,right,result;
		char op;
		public int getLeft() {
			return left;
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
		public void setLeft(int left) {
			this.left = left;
		}
		

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercise e=new Exercise();
		System.out.println("----------如下是混合运算习题----------");
		e.generateExercise();
		e.printExercise();
		
		System.out.println("----------如下是加法运算习题----------");
		e.generateAddExercise();
		e.printExercise();
		
		System.out.println("----------如下是减法运算习题----------");
		e.generateSubExercise();
		e.printExercise();
	}
	
	private Equation[] Exercise;

	public Equation[] getExercise() {
		return Exercise;
	}

	public void setExercise(Equation[] exercise) {
		Exercise = exercise;
	}
	
	public String toString(Equation e)
	//将算法转换为字符串的方法
	{
		return " "+e.getLeft()+e.getOp()+e.getRight()+"="+e.getResult();
	}
	
	public int generateOperand(int min,int max)
	//生成随机的整数的方法
	{
		Random r=new Random();
		return r.nextInt(max-min+1)+min;
	}
	
	public boolean isBetween(int value,int min,int max)
	//判断运算结果在某个值范围内的方法
	{
		return value>=min&&value<=max;
	}
	
	public boolean isEqual(Equation e1,Equation e2)
	//判断两个算式是否相等的方法
	{
		boolean b=false;
		if(e1.getOp()!=e2.getOp())
		{
			b=false;
		}
		else
		{
			b=e1.getLeft()==e2.getLeft()&&e1.getRight()==e2.getRight();
		}
		return b;
	}
	
	public int calculateAddEquation(int left,int right)
	//计算机加法运算
	{
		return left+right;
	}
	
	public int calculateSubEquation(int left,int right)
	//计算减法算式
	{
		return left-right;
	}
	
	public boolean occursIn(Equation e,Equation[] ex,int n)
	//判断算式是否已经在习题中存在
	{
		boolean b=false;
		for(int i=0;i<n;i++)
		{
			if(isEqual(e,ex[i])) {
				b=true;
				break;
			}
		}
		return b;
	}
	
	public Equation generateAddEquation()
	//生成加法算式
	{
		Equation e=new Equation();
		int left,right,result;
		while(true){
			left=generateOperand(0,100);
			right=generateOperand(0,100);
			result=calculateAddEquation(left,right);
			if(isBetween(result,0,100))
			{
				e.setLeft(left);
				e.setRight(right);
				e.setOp('+');
				e.setResult(result);
				break;
			}
		}
		return e;
	}
	
	public Equation generateSubEquation()
	//生成减法算式
	{
		Equation e=new Equation();
		int left,right,result;
		while(true){
			left=generateOperand(0,100);
			right=generateOperand(0,100);
			result=calculateAddEquation(left,right);
			if(isBetween(result,0,100))
			{
				e.setLeft(left);
				e.setRight(right);
				e.setOp('-');
				e.setResult(result);
				break;
			}
		}
		return e;
	}
	
	public Equation generateEquation()
	//生成混合算式
	{
		Equation e=new Equation();
		Random r=new Random();
		if(r.nextInt(2)==1)
		{
			e=generateAddEquation();
		}
		else 
		{
			e=generateSubEquation();
		}
		return e;
	}
	
	public void generateExercise()
	//构造混合习题
	{
		Exercise =new Equation[50];
		for(int i=0;i<50;)
		{
			Equation e=generateEquation();
			if(occursIn(e,Exercise,i)) {
				continue;
			}
			else {
				Exercise[i]=e;
				i++;
			}
		}
	}
	
	public void generateAddExercise()
	//构造加法习题
	{
		Exercise =new Equation[50];
		for(int i=0;i<50;)
		{
			Equation e=generateAddEquation();
			if(occursIn(e,Exercise,i)) {
				continue;
			}
			else {
				Exercise[i]=e;
				i++;
			}
		}
	}
	
	public void generateSubExercise()
	//构造减法习题
	{
		Exercise =new Equation[50];
		for(int i=0;i<50;)
		{
			Equation e=generateSubEquation();
			if(occursIn(e,Exercise,i)) {
				continue;
			}
			else {
				Exercise[i]=e;
				i++;
			}
		}
	}
	
	public void printExercise()
	//打印习题
	{
		for(int i=0;i<50;i++)
		{
			System.out.print("("+(i+1)+")"+toString(Exercise[i])+'\t');
			if((i+1)%5==0)
			{
				System.out.println();
			}
		}
	}

}	
