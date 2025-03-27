package myPackage;

import java.util.Arrays;

public class Ex10_11_Test
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ex10_11_Student_num[] s1 = new Ex10_11_Student_num[]
				{
						new Ex10_11_Student_num("jiwoo", 202037071),
						new Ex10_11_Student_num("jiwoon", 202037075),
						new Ex10_11_Student_num("jiwon", 202037072),
						new Ex10_11_Student_num("jiwoong", 202037074),
						new Ex10_11_Student_num("jiyoon", 202037073),
						};
		
		Ex10_11_Student_name[] s2 = new Ex10_11_Student_name[]
				{
						new Ex10_11_Student_name("jiwoo", 202037071),
						new Ex10_11_Student_name("jiwoon", 202037075),
						new Ex10_11_Student_name("jiwon", 202037072),
						new Ex10_11_Student_name("jiwoong", 202037074),
						new Ex10_11_Student_name("jiyoon", 202037073),
						};
		
		Arrays.sort(s1);
		Arrays.sort(s2);
		
		System.out.println("Sort by student number");
		for(int i=0; i<5; i++)
		{
			s1[i].writeOutput();
		}
		
		System.out.println("\nSort by student name");
		for(int i=0; i<5; i++)
		{
			s2[i].writeOutput();
		}
	}
}

