package codes;

import java.util.Random;
import java.util.Scanner;

public class Guessnum {
    int num,i, guess, count = 0;
    Random ran = new Random();
    Scanner src = new Scanner(System.in);
    int random = ran.nextInt(100) + 1;
    boolean check = false;

    public void Guess() {
       
            for (int j = 0; j <= 5; j++) {
                System.out.println("Enter your number between 1 to 100");
                num = src.nextInt();
                src.nextLine();

                if (random > num) {
                    System.out.println("Number is greater than " + num);
                } else if (random < num) {
                    System.out.println("Number is smaller than " + num);
                } else {
                    System.out.println("Number is correct. Random number was: " + random +
                            " and your number is also " + num+"you guessed in "+(count+1)+"th "+"time ");
                    check = true;
                   break;
                }
                count++;
            }

            if (check==true) {
                return;
            }
            else {

            System.out.println("Sorry, 5 attempts done.");

            System.out.println("Would you like to try on another round again? Enter yes or no");
            String round = src.nextLine().toUpperCase();
            if (round.equals("YES")) {
                Guess();
            } else {
                System.out.println("Thanks for playing.The number was" + random);
                return;
           
            }}
        }
    

    public static void main(String[] args) {
        Guessnum g = new Guessnum();
        g.Guess();
    }
}
