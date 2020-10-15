package sc.ch3;

public class Student {
	private static Exercise exercise;
	
	
	public Student(){
		
	}
	
	public static void printExercise(){
		int i=0;
		while(exercise.hasNext()){
			i++;
			System.out.print("("+i+")"+exercise.next().toString());
		}
		if (i%5==0) {
			System.out.println();
		}else{
			System.out.print("\t");
		}
		
		
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		exercise =new Exercise();
		exercise.generateExercise();
		exercise.printExercise();
		
	}

}
