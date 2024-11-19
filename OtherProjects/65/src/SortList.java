import java.util.ArrayList;
import java.util.Scanner;
public class SortList {
    
    static void sorter(ArrayList<Integer> numlist){
        
        numlist.sort(null);
        Double sum = 0.0;
        for (int k : numlist){
            sum += k;
        }
        Double avg = sum / numlist.size();
        System.out.print("The sorted list is ");
        System.out.println(numlist);
        System.out.println("The average is " + avg);
        System.out.println("The sum is " + sum);

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 for user input, press 2 for constant.");
        int userinput = scanner.nextInt();
        if (userinput == 1){
            System.out.println("Number of element in list:");
            int no = scanner.nextInt();
            ArrayList<Integer> inputlist = new ArrayList<Integer>();
            for (int i = 0; i < no; i++){
                System.out.println("Next number: ");
                int newnumber = scanner.nextInt();
                inputlist.add(newnumber);
            }
            sorter(inputlist);
        }
        if (userinput == 2){
            System.out.println("Change the input variable in the source code to a constant in order to sort a constant list.");
            System.out.println("Currently printing placeholder sorting for input = {9, 4, 7, 3, 5, 6, 1, 8, 2}:");
            ArrayList<Integer> newlist = new ArrayList<Integer>();
            int[] input = {9, 4, 7, 3, 5, 6, 1, 8, 2};
            // Change the input variable in order to sort the list, or call the sorter method directly.
			// Halfway through doing my homework, I realized I didn't really need this part... Ah well!
            for (int k : input){
                newlist.add(k);
            }
            sorter(newlist);
        }
        else {
            System.out.println("Invalid input.");
        }
        scanner.close();
    }
}
