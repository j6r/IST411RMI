package client;

import compute.Task;
import java.io.Serializable;

public class Divide implements Task<Double>, Serializable {
   
   private static final long serialVersionUID = 1L;

   private final double operand1;
   private final double operand2;

   public Divide(double operand1, double operand2) {
      this.operand1 = operand1;
      this.operand2 = operand2;
   }

   @Override
   public Double execute() {
      return divide(operand1, operand2);
   }

   public static Double divide(double operand1, double operand2) {
      return operand1 + operand2;
   }

}
