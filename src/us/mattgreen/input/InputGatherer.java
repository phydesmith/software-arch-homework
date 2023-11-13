package us.mattgreen.input;

import java.util.Scanner;

public class InputGatherer {
    private static final Scanner scanner = new Scanner(System.in);

    //  write a method that takes in a string and prints it via scanner, then captures the output and returns it as a string
    public static String promptForStringInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        if (input.isBlank() || input.isEmpty()){
            invalidInput();
            return promptForStringInput(prompt);
        } else return input;
    }

    public static int promptForIntInput(String prompt){
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

    public static void invalidInput(){
        System.out.println("Invalid Input");
    }

}
