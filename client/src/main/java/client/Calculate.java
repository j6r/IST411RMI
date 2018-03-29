package client;

import compute.Compute;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.math.BigDecimal;
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
         String operator;

         System.out.println("Please enter the first operand: ");
         operand1 = scanner.nextInt();

         System.out.println("Please enter the second operand: ");
         operand2 = scanner.nextInt();

         System.out.println("Please enter the operator [+ - * /]: ");
         operator = scanner.next();

         switch (operator) {
            case "+":
               System.out.println("+");
               break;
            case "-":
               System.out.println("-");
               break;
            case "*":
               System.out.println("*");
               break;
            case "/":
               System.out.println("/");
               break;
            default:
               System.out.println("Please enter a valid operator.");
         }

         Pi task = new Pi(operand1);
         BigDecimal pi = comp.executeTask(task);
         System.out.println(pi);
      } catch (Exception e) {
         System.err.println("ComputePi exception:");
         e.printStackTrace();
      }

   }
}
