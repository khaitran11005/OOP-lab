package hust.soict.dsai.lab01;



import javax.swing.JOptionPane;
public class Calculator {
    public static void main(String[] args) {
        int choice1 = JOptionPane.showOptionDialog(null, "Do you want to calculate a linear equation?", "Calculator",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, null, null);
        if (choice1 == JOptionPane.YES_OPTION){
            String a1, a2, a3;
            // a1 * x + a2 = a3
            a1 = JOptionPane.showInputDialog(null, "Please input a (ax + b = c)", JOptionPane.INFORMATION_MESSAGE);
            a2 = JOptionPane.showInputDialog(null, "Please input b (ax + b = c)", JOptionPane.INFORMATION_MESSAGE);
            a3 = JOptionPane.showInputDialog(null, "Please input c (ax + b = c)", JOptionPane.INFORMATION_MESSAGE);
            try{
                double numa1 = Double.parseDouble(a1);
                double numa2 = Double.parseDouble(a2);
                double numa3 = Double.parseDouble(a3);
                if (numa1 == 0 && numa2 == numa3){
                    JOptionPane.showMessageDialog(null, "Infinite solutions");
                    System.exit(0);
                } else if (numa1 == 0){
                    JOptionPane.showMessageDialog(null, "No solution");
                    System.exit(0);
                }
                double sol = (numa3 - numa2) / numa1;
                JOptionPane.showMessageDialog(null, "The solution to " + a1 + " * x + " + a2 + " = " + a3 + " is " + sol);
                System.exit(0);            
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Invalid number/numbers.");
                System.exit(0);
            }
            
        }
        int choice2 = JOptionPane.showOptionDialog(null, "Do you want to calculate a linear system?", "Calculator",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, null, null);
        if (choice2 == JOptionPane.YES_OPTION){
            String b1, b2, b3, b4, b5, b6;
            // b1 * x + b2 * y = b3
            // b4 * x + b5 * y = b6
            b1 = JOptionPane.showInputDialog(null, "Please input a1 (a1x + b1y = c1)", JOptionPane.INFORMATION_MESSAGE);
            b2 = JOptionPane.showInputDialog(null, "Please input b1 (a1x + b1y = c1)", JOptionPane.INFORMATION_MESSAGE);
            b3 = JOptionPane.showInputDialog(null, "Please input c1 (a1x + b1y = c1)", JOptionPane.INFORMATION_MESSAGE);
            b4 = JOptionPane.showInputDialog(null, "Please input a2 (a2x + b2y = c2)", JOptionPane.INFORMATION_MESSAGE);
            b5 = JOptionPane.showInputDialog(null, "Please input b2 (a2x + b2y = c2)", JOptionPane.INFORMATION_MESSAGE);
            b6 = JOptionPane.showInputDialog(null, "Please input c2 (a2x + b2y = c2)", JOptionPane.INFORMATION_MESSAGE);
            try{
                double numb1 = Double.parseDouble(b1);
                double numb2 = Double.parseDouble(b2);
                double numb3 = Double.parseDouble(b3);
                double numb4 = Double.parseDouble(b4);
                double numb5 = Double.parseDouble(b5);
                double numb6 = Double.parseDouble(b6);
                double D = numb1 * numb5 - numb2 * numb4;
                double D1 = numb3 * numb5 - numb6 * numb2;
                double D2 = numb1 * numb6 - numb4 * numb3;
                if (D == 0 && D1 == 0 && D2 == 0){
                    JOptionPane.showMessageDialog(null, "Infinite solutions");
                    System.exit(0);
                } else if (D == 0){
                    JOptionPane.showMessageDialog(null, "No solution");
                    System.exit(0);
                }
                double x = D1/D;
                double y = D2/D;
                JOptionPane.showMessageDialog(null, "Solution: x = " + x + ", y = " + y);
                System.exit(0);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Invalid number/numbers.");
                System.exit(0);
            }

        }
        int choice3 = JOptionPane.showOptionDialog(null, "Do you want to calculate a quadratic equation?", "Calculator",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, null, null);
        if (choice3 == JOptionPane.YES_OPTION){
            String c1, c2, c3;
            // c1 * x^2 + c2 * x + c3 = 0
            c1 = JOptionPane.showInputDialog(null, "Please input a (a * x^2 + b * x + c = 0)", JOptionPane.INFORMATION_MESSAGE);
            c2 = JOptionPane.showInputDialog(null, "Please input b (a * x^2 + b * x + c = 0)", JOptionPane.INFORMATION_MESSAGE);
            c3 = JOptionPane.showInputDialog(null, "Please input c (a * x^2 + b * x + c = 0)", JOptionPane.INFORMATION_MESSAGE);
            
            try{
                double numc1 = Double.parseDouble(c1);
                double numc2 = Double.parseDouble(c2);
                double numc3 = Double.parseDouble(c3);
                
                double delta = numc2 * numc2 - 4 * numc1 * numc3;
                if (numc1 == 0){
                    JOptionPane.showMessageDialog(null, "Not quadratic - use the linear equation solver!");
                    System.exit(0);
                } else if (delta < 0){
                    JOptionPane.showMessageDialog(null, "No real solutions.");
                    System.exit(0);
                }
                double x1 = (- numc2 + Math.sqrt(delta))/ 2 / numc1;
                double x2 = (- numc2 - Math.sqrt(delta))/ 2 / numc1;
                JOptionPane.showMessageDialog(null, "Solution: x1 = " + x1 + ", x2 = " + x2);

            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Invalid number/numbers.");
                System.exit(0);
            }
        }
    }
}
