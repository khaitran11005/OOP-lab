package hust.soict.dsai.lab01;


import java.util.Scanner;
public class DoubleCalc {
    public static void main(String[] args) {
        Scanner numscan = new Scanner(System.in);
        System.out.println("First number:");
        Double num1 = numscan.nextDouble();
        System.out.println("Second number:");
        Double num2 = numscan.nextDouble();
        if (num2 == 0){
            System.out.println("Division by 0 is not well-defined. Please try a different number.");
        }
        else {
            Double sum = num1 + num2;
            Double diff = num1 - num2;
            Double prod = num1 * num2;
            Double quot = num1 / num2;
            System.out.println("Sum: " + sum + ", Difference: " + diff +", Product: " + prod + ", Quotient: " + quot);
        }

    }
}
