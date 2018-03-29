package engine;

import compute.Compute;
import compute.Task;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class ComputeEngine implements Compute {

   public ComputeEngine() {
      super();
   }

   @Override
   public <T> T executeTask(Task<T> t) {
      return t.execute();
   }

   public static void main(String[] args) {
      if (System.getSecurityManager() == null) {
         System.setSecurityManager(new SecurityManager());
      }
      try {
         String name = "Compute";
         Compute engine = new ComputeEngine();
         Compute stub
                 = (Compute) UnicastRemoteObject.exportObject(engine, 0);

//         System.setProperty("java.rmi.server.hostname","127.0.0.1");
         
         Registry registry = LocateRegistry.getRegistry();
         registry.rebind(name, stub);
         System.out.println("ComputeEngine bound");
      } catch (Exception e) {
         System.err.println("ComputeEngine exception:");
         e.printStackTrace();
      }
   }
}
