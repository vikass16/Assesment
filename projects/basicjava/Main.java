package projects.basicjava;


import java.util.Random;
import java.util.Scanner;

// Guess Number game
public class Main {
    public static void main(String[] args) {
        // Initialization
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // Creating random Number
        int min = 1;
        int max = 100;
        int targetNumber = random.nextInt((max-min)+1)+min;

        // Performing Operations

        System.out.println("Min value is "+min+" || Maximum value is "+max);

        int userGuess = 0;
        int attempts = 0;

        while(userGuess != targetNumber){
            System.out.print("Entering in the Game. Please Enter a number : ");
            userGuess = sc.nextInt();
            attempts++;

            if(userGuess < targetNumber){
                System.out.println("Number is Low!!");
            }else if(userGuess > targetNumber){
                System.out.println("Number is high");
            }else {
                System.out.println("Congratulations You guess the correct number!!");
                System.out.println("you got in "+attempts+" attempts..");
            }
        }
    }
}
