package codes;

import java.util.Random;
import java.util.Scanner;

public class guess2 {
	
	public void gsuess() {
		Random ran=new Random();
		String [] gsuess={"paper","scissor","rock"};
		int randomIndex = ran.nextInt(gsuess.length);
        String gs = gsuess[randomIndex];
        System.out.println("select :scissor,paper or rock?");
        Scanner src=new Scanner(System.in);
        String hum=src.nextLine();
			if(hum.equals(gs)) {
				System.out.println("you selected "+hum+" computer selected "+gs+".draw");
			}
			else if(
				 (hum.equals("scissor") && gs.equals("paper")) ||
		            (hum.equals("paper") && gs.equals("rock")) ||
		            (hum.equals("rock") && gs.equals("scissors"))) {
				System.out.println("you selected "+hum+" computer selected "+gs+".you won");
			}
			else {
				System.out.println("you selected "+hum+" computer selected "+gs+".computer wonn");
			}
			
			
		}
		
	
		
	public static void main(String[]args) {
	                   guess2 gs2=new guess2();
	                   gs2.gsuess();

	}
	

}
