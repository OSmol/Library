package by.trjava.library.view;

import java.util.Scanner;

public class InformationInput {

    public int choiceInput(){
        Scanner scanner;
        int number;

        scanner =new Scanner(System.in);
        number = scanner.nextInt();

        return number;
    }

    public String dataInput(){
        Scanner scanner;
        String data;

        scanner =new Scanner(System.in);
        data = scanner.nextLine();

        return data;
    }

}
