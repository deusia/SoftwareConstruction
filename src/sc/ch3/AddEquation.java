/**
 * 
 */
package sc.ch3;

/**
 * @author Administrator
 *
 */
public class AddEquation extends Equation {
	/*
	 * 
	 */
	public AddEquation(){
		generateEquation('+');
	}
	public AddEquation(String s){
		int index = s.indexOf("+");
		int length = s.length();
		
		this .setLeft(Integer.parseInt(s.substring(0,index)));
		this .setRight(Integer.parseInt(s.substring(index+1,length)));
		//this .setOp('+');
		this.setOp(s.charAt(index));//取index的字符
		this.setResult(calculate());
	}
	protected int calculate() {
		// TODO 自动生成的方法存根
		return this.getLeft()+this.getRight();
	}

}
