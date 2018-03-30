package client;

import compute.Compute;
import compute.Task;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Calculate {

   public static void main(String args[]) {

      if (System.getSecurityManager() == null) {
         System.setSecurityManager(new SecurityManager());
      }
      try (Scanner scanner = new Scanner(System.in)) {
         String name = "Compute";
         Registry registry = LocateRegistry.getRegistry(0);
         Compute comp = (Compute) registry.lookup(name);

         int operand1;
         int operand2;
         String operator = "";
         double result = 0.00;
         Task<Double> task;

         System.out.println("Please enter the first operand: ");
         operand1 = scanner.nextInt();

         System.out.println("Please enter the second operand: ");
         operand2 = scanner.nextInt();

         System.out.println("Please enter the operator [+ - * /]: ");
         operator = scanner.next();

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
            System.out.printf("%d %s %d = %f%n",
                    operand1, operator, operand2, result);
         } else {
            System.out.printf("Error: unknown operator %s%n", operator);
         }

      } catch (Exception e) {
         System.err.println("Calculate exception:");
         e.printStackTrace();
      }

   }
}
