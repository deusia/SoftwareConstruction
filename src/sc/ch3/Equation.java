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
		 //��������������ķ���
		Random r=new Random(max+1);
		return r.nextInt(max-min+1);
	}
	
	private boolean isBetween(int value,int min,int max){
        //�ж��������ĳ��ֵ�÷�Χ�ڵķ���
        if (value >= min && value <= max) {
            return true;
        } else {
            return false;
        }
	}
	
	public boolean isEqual(Equation e){
        //�ж�������ʽ�Ƿ���ȵķ���
        boolean b = false;
        if (this.getOp() != e.getOp()) {
            b = false;
        } else {
            b = (this.getLeft() == e.getLeft() && this.getRight() == e.getRight());
        }

        return b;
	}
	
	//����ʽת��Ϊ�ַ������� 	45+32
	public String toString(){
		return ""+this.left+this.op+this.right;
	}
	//����ʽת��Ϊ�ַ������� 	45+32=
	public String toString2(){
		String s=toString();
		return s+"=";
	}
	//����ʽת��Ϊ�ַ������� 	45+32=87
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
