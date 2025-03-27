package myPackage;

public class Ex9_10_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex9_10_Person[] p = new Ex9_10_Person[]
				{new Ex9_10_Faculty("Jiwoo", 15, "Professor of Computer Science"), new Ex9_10_Staff("Jiwoon", 4), new Ex9_10_Undergraduate("Jiwoo",
						202037071, 2), new Ex9_10_Student("Jiyoon", 202030001)};
		
		p[0].writeOutput();
		p[1].writeOutput();
		p[2].writeOutput();
		p[3].writeOutput();		
	}

}
