package sc.ch3;

import java.util.*;

public abstract class Equation {
	
	private final int MAX=100;
	private final int MIN =0;
	private int left;
	private int right;
	private int result;
	private char op;
	
	public Equation(){
		
	}

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
	
	private int generateRandom(int min,int max){
		 //生成随机的整数的方法
		Random r=new Random(max+1);
		return r.nextInt(max-min+1);
	}
	
	private boolean isBetween(int value,int min,int max){
        //判断运算结在某个值得范围内的方法
        if (value >= min && value <= max) {
            return true;
        } else {
            return false;
        }
	}
	
	public boolean isEqual(Equation e){
        //判断两个算式是否相等的方法
        boolean b = false;
        if (this.getOp() != e.getOp()) {
            b = false;
        } else {
            b = (this.getLeft() == e.getLeft() && this.getRight() == e.getRight());
        }

        return b;
	}
	
	//将算式转换为字符串类型 	45+32
	public String toString(){
		return ""+this.left+this.op+this.right;
	}
	//将算式转换为字符串类型 	45+32=
	public String toString2(){
		String s=toString();
		return s+"=";
	}
	//将算式转换为字符串类型 	45+32=87
	public String toString3(){
		String s=toString2();
		return s+this.result;
	}
	
	public void generateEquation(char op){
		do{
			left=generateRandom(MIN, MAX);
			right=generateRandom(MIN, MAX);
			result=calculate();
		}while(!isBetween(result, MIN, MAX));
		
		this.setOp(op);
	}		
	
	protected abstract int calculate();
	

}
