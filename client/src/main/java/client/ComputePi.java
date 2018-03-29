package client;

import compute.Compute;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.math.BigDecimal;
import java.util.Scanner;

public class ComputePi {

   public static void main(String args[]) {

      if (System.getSecurityManager() == null) {
         System.setSecurityManager(new SecurityManager());
      }
      try (Scanner scanner = new Scanner(System.in)) {
         String name = "Compute";
         Registry registry = LocateRegistry.getRegistry(0);
         Compute comp = (Compute) registry.lookup(name);

         System.out.println("Please enter a number to compute Pi: ");
         int i = scanner.nextInt();

         Pi task = new Pi(i);
         BigDecimal pi = comp.executeTask(task);
         System.out.println(pi);
      } catch (Exception e) {
         System.err.println("ComputePi exception:");
         e.printStackTrace();
      }

   }
}
