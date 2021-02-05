package com.company;

import java.util.Scanner;

public class NumberConverter {
    public static void main(String[] args) {
        char [] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number Converter: ");
        printConvertingOptions();

        while(true){
            System.out.println("In which numeral system will the input be? (2-16): ");
            int numeralSystem = scanner.nextInt();
            scanner.nextLine();
            if (numeralSystem == 1){
                System.out.println("Exiting program.");
                break;
            }
            System.out.println("Enter a value: ");
            String input = scanner.nextLine().toUpperCase();

            int number = convertToDecimalNumber(input, numeralSystem, chars);

            System.out.println("Convert it to which numeral system? (2-16): ");
            numeralSystem = scanner.nextInt();
            if (numeralSystem == 1){
                System.out.println("Exiting program.");
                break;
            }
            System.out.println("Converted number: " + convertDecimalNumber(number, numeralSystem, chars));
        }
    }

    public static int convertToDecimalNumber(String numberGiven, int numeralSystem, char [] charsGiven){
        if (numeralSystem == 10)
            return Integer.parseInt(numberGiven);

        char [] charsNeeded = new char[numeralSystem];
        for (int i = 0; i < charsNeeded.length; i++) {
            charsNeeded[i] = charsGiven[i];
        }

        int totalValue = 0;
        for (int i = 0; i < numberGiven.length(); i++) {
            totalValue *= numeralSystem;
            for (int j = 0; j < charsNeeded.length; j++){
                if (numberGiven.charAt(i) == charsNeeded[j]){
                    totalValue += j;
                    break;
                }
            }
        }
        return totalValue;
    }

    public static String convertDecimalNumber(int numberGiven, int numeralSystem, char [] charsGiven){
        if (numeralSystem < 2)
            return "Invalid input";

        char [] charsNeeded = new char[numeralSystem];
        for (int i = 0; i < charsNeeded.length; i++) {
            charsNeeded[i] = charsGiven[i];
        }

        StringBuilder convertedNumber = new StringBuilder();
        int remainder;

        while(numberGiven > 0){
            remainder = numberGiven % charsNeeded.length;
            convertedNumber.append(charsNeeded[remainder]);
            numberGiven /= charsNeeded.length;
        }

        return convertedNumber.reverse().toString();
    }

    public static void printConvertingOptions(){
        System.out.println("1 - EXIT PROGRAM");
        System.out.println("2 - BINARY");
        System.out.println("3 - TERNARY");
        System.out.println("4 - QUATERNARY");
        System.out.println("5 - QUINARY");
        System.out.println("6 - SENARY");
        System.out.println("7 - SEPTENARY");
        System.out.println("8 - OCTAL");
        System.out.println("9 - NONARY");
        System.out.println("10 - DECIMAL");
        System.out.println("11 - UNDECIMAL");
        System.out.println("12 - DUODECIMAL");
        System.out.println("13 - TRIDECIMAL");
        System.out.println("14 - TETRADECIMAL");
        System.out.println("15 - PENTADECIMAL");
        System.out.println("16 - HEXADECIMAL");
    }
}