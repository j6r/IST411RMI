package client;

import compute.Compute;
import compute.Task;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.InputMismatchException;

public class Calculate {

   public static void main(String args[]) {

      if (System.getSecurityManager() == null) {
         System.setSecurityManager(new SecurityManager());
      }
      
      try (Scanner scanner = new Scanner(System.in)) {
         String name = "Compute";
         Registry registry = LocateRegistry.getRegistry(0);
         Compute comp = (Compute) registry.lookup(name);

         double operand1;
         double operand2;
         String operator = "";
         double result;
         Task<Double> task;

         System.out.println("Welcome to the calculator!");
         System.out.println("You can enter calculations in the format 'n1 op n2'");
         System.out.println("where n1 and n2 are doubles and op is one of the following mathematical operators: +,-,*,/.");
         System.out.println("Please enter your calculation: ");
                  
         operand1 = scanner.nextDouble();
         operator = scanner.next();
         operand2 = scanner.nextDouble();

         switch (operator) {
            case "+":
               task = new Add(operand1, operand2);
               break;
            case "-":
               task = new Subtract(operand1, operand2);
               break;
            case "*":
               task = new Multiply(operand1, operand2);
               break;
            case "/":
               task = new Divide(operand1, operand2);
               break;
            default:
               task = null;
         }

         if (task != null) {
            result = comp.executeTask(task);
            System.out.printf("%f %s %f = %f%n",
                    operand1, operator, operand2, result);
         } else {
            Logger.getLogger(Calculate.class.getName()).log(Level.SEVERE, 
                    String.format("Error: unknown operator %s%n", operator));
         }

      } catch (RemoteException|NotBoundException ex) {
         Logger.getLogger(Calculate.class.getName()).log(Level.SEVERE, "Server error", ex);
      } catch (InputMismatchException ex) {
         Logger.getLogger(Calculate.class.getName()).log(Level.SEVERE, "Unable to parse calculation.", ex);
      }
   }
}
