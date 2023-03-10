package task1;

class Student{
	String name;
	int rollNo;
}

class Exam extends Student{
	int math,physics,chemistry;
	
}

class Result extends Exam{
	int totalMark=0;
	int total() {
		totalMark=math+physics+chemistry;
		return totalMark;
	}
}

public class Evaluation {

	public static void main(String[] args) {
		Result person =new Result();
		
		person.name="Varun";
		person.rollNo=10007;
		person.math=87;
		person.physics=90;
		person.chemistry=80;
		
		System.out.println(person.total());
		
	}

}
