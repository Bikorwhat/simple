package codes;

import java.util.Scanner;

public class Grade {
	public void Test() {
		int math,science,computer,english,sociology;
		Scanner src=new Scanner(System.in);
		System.out.println("enter marks obtained in Math:");
		math=src.nextInt();
		System.out.println("enter marks obtained in Science:");
		science=src.nextInt();
		System.out.println("enter marks obtained in COmputer:");
		computer=src.nextInt();
		System.out.println("enter marks obtained in English:");
		english=src.nextInt();
		System.out.println("enter marks obtained in Sociology:");
		sociology=src.nextInt();
		double total=math+science+computer+english+sociology;	
		double percent=(total/500)*100;
		 String grade;
	        if (percent >= 90) {
	            grade = "A+";
	        } else if (percent >= 80) {
	            grade = "A";
	        } else if (percent >= 70) {
	            grade = "B+";
	        } else if (percent >= 60) {
	            grade = "B";
	        } else if (percent >= 50) {
	            grade = "C+";
	        } else if (percent >= 40) {
	            grade = "C";
	        } else if (percent >= 30) {
	            grade = "D+";
	        } else if (percent >= 20) {
	            grade = "D";
	        } else {
	            grade = "E";
	        } 
	
	        System.out.println("Total Marks: " + total);
	        System.out.println("Percentage: " + percent);
	        System.out.println("Grade: " + grade);
	        src.close();
	}
	public static void main(String[] args) {
		Grade g=new Grade();
		g.Test();
	}

}
