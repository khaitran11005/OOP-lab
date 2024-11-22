package hust.soict.dsai.lab01;

import java.util.Scanner;
public class StarDrawing {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input value: ");
        int PyraNo = keyboard.nextInt();
        for (int i = 0; i < PyraNo; i++){
            for (int k = 0; k < PyraNo - i; k++){
                System.out.print(" ");

            }
            for (int p = 0; p < 2 * i + 1; p++){
                System.out.print("*");
            }
            for (int n = 0; n < PyraNo - i; n++){
                System.out.print(" ");
            }
            System.out.println("");
        }
        keyboard.close();
    
    }
}