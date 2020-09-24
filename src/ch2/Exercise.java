package ch2;

import java.util.Random;

public class Exercise {
	
	private class Equation{

		private int left;
		private int right;
		private int result;
		private char op;
		
//		Equation(int left,int right,int result,char op){
//			this.left=left;
//			this.right=right;
//			this.result=result;
//			this.op=op;
//		}
		
		
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
	}
	

	private Equation[] Exercise;
	
	public Equation[] getExercise(){return Exercise;}
	
	public String toString(Equation e){
	//将算是转化为字符串的方法
		return e.left+e.op+e.right+"="+e.result;
	}
	
	public int generateOperand(int max){
	//生成随机的整数的方法
		int operand=(int)(Math.random()*max);
		return operand;
	}
	
	public boolean isBetween(int value,int min,int max){
	//判断运算结在某个值得范围内的方法
		if(value>=min&&value<=max){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isEqual(Equation e1,Equation e2){
	//判断两个算式是否相等的方法
		boolean b=false;
		if(e1.getOp()!=e2.getOp()){
			b=false;
		}else{
			b=(e1.getLeft()==e2.getLeft()&&e1.getRight()==e2.getRight());
		}
		
		return b;
	}
	
	public int calculateAddEquation(int left,int right){
	//计算加法算式
		return left+right;
	}
	
	public int calculateSubEquation(int left,int right){
	//计算减法算式
		return left-right;
	}
	
	public boolean occursIn(Equation e,Equation[] ex, int n){
	//判断算式是否已经在习题中	
		boolean b=false;
		for(int i=0;i<n;i++){
			if(isEqual(e, ex[i])){
				b=true;
				break;
			}
		}
		return b;
	}
	
	public Equation generateAddEquation(){
	//生成加法算式
		Equation e =new Equation();
		
		while(true){
			e.setLeft(generateOperand(100));
			e.setOp('+');
			e.setRight(generateOperand(100));
			e.setResult(calculateAddEquation(e.getLeft(), e.getRight()));
			
			if(isBetween(e.getResult(), 0, 100)){
				break;
			}			
		}
		
		return e;
		
		
		
	}
	
	public Equation generateSubEquation(){
		//生成减法算式
		Equation e =new Equation();
		while(true){
			e.setLeft(generateOperand(100));
			e.setOp('-');
			e.setRight(generateOperand(100));
			e.setResult(calculateSubEquation(e.getLeft(), e.getRight()));
			
			if(isBetween(e.getResult(), 0, 100)){
				break;
			}
		}

		
		return e;
		
	}
	
	public Equation generateEquation(){
		Equation e=new Equation();
		Random r=new Random();
		if(r.nextInt(2)==1){
			e=generateAddEquation();
		}else{
			e=generateSubEquation();
		}
		
		return e;
	}
	
	public void generateExercise(){
	//生成混合习题
		Exercise=new Equation[50];
		for (int i = 0; i < Exercise.length;) {
			Equation e=generateEquation();
			if(!occursIn(e, Exercise, i)){
				Exercise[i]=e;
				i++;
			}
		}
	}
	
	public void generateAddExercise(){
	//生成加法习题
		Exercise=new Equation[50];
		for (int i = 0; i < Exercise.length;) {
			Equation e=generateAddEquation();
			if(!occursIn(e, Exercise, i)){
				Exercise[i]=e;
				i++;
			}
		}
	}
	
	public void generateSubExercise(){
	//生成减法习题
		Exercise=new Equation[50];
		for (int i = 0; i < Exercise.length;) {
			Equation e=generateSubEquation();
			if(!occursIn(e, Exercise, i)){
				Exercise[i]=e;
				i++;
			}
		}
	}
	
	public void printExercise(){
		for (int i = 1; i <= 50; i++) {
			System.out.print("("+i+")"+toString(Exercise[i])+'\t');
			if(i%5==0){
				System.out.print('\n');	
			}
		}
	}
	
	public static void main(String[] args) {
		Exercise e=new Exercise();
		e.generateExercise();
		e.printExercise();
		
		e.generateAddEquation();
		e.printExercise();
		
		e.generateSubEquation();
		e.printExercise();
		
	}

}
