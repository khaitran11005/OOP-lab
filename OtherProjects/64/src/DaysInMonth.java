import java.util.Scanner;
public class DaysInMonth {

    public static void main(String[] args){
        
        Scanner scanbro = new Scanner(System.in);
        String[] ThirtyOneDayMonths = {"January", "March", "May", "July", "August", "October", "December", "Jan", "Mar", "May", "Jul", "Aug", "Oct", "Dec", "Jan.", "Mar.", "May.", "Jul.", "Aug.", "Oct.", "Dec.", "1", "3", "5", "7", "8", "10", "12"};
        String[] ThirtyDayMonths = {"April", "June", "September", "November", "Apr", "Jun", "Sep", "Nov", "Apr.", "Jun.", "Sep.", "Nov.", "4", "6", "9", "11"};
        String[] Febs = {"February", "Feb", "Feb.", "2"};
        System.out.println("Enter a month: ");
        String month;
        int year = 0;
        int days = 0;
        boolean ValidYear = false, ValidMonth = false;

        do{
            month = scanbro.nextLine();
            for (String n : ThirtyOneDayMonths){
                if (month.equals(n)){
                    days = 31;
                    ValidMonth = true;
                }
            }
            for (String k : ThirtyDayMonths){
                if (month.equals(k)){
                    days = 30;
                    ValidMonth = true;
                }
            }
            for (String m : Febs){
                if (month.equals(m)){
                    ValidMonth = true;
                }
            }
            if (!ValidMonth){
                System.out.println("Invalid month, please try again.");
            }

        } while (!ValidMonth);
        System.out.println("Enter a year:");

        do{
            try{
                year = Integer.parseInt(scanbro.next());
                ValidYear = true;


            }catch(Exception e){
                System.out.println("Invalid year, please try again.");
            }
            
        } while (!ValidYear);

        if (days == 0){
            if (year % 4 != 0){
                days = 28;
            
            }
            else if (year % 100 == 0 && year % 400 != 0){
                days = 28;
            }
            else{
                days = 29;
            }
        }

        System.out.println("There are " + days + " days in the month.");
        scanbro.close();
    }
}
