package sc.ch3;

public class AddEquation extends Equation{

	public AddEquation(){
		generateEquation('+');
	}
	
	public AddEquation(String s){
		int index=s.indexOf("+");
		int length =s.length();
		
		this.setLeft(Integer.parseInt(s.substring(0,index)));
		this.setRight(Integer.parseInt(s.substring(index+1,length)));
		this.setOp('+');
		this.setResult(calculate());
	}

	
	@Override
	protected int calculate() {
		// TODO �Զ����ɵķ������
		return this.getLeft()+this.getRight();
	}
	
	
}
