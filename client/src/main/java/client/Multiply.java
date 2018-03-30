package client;

import compute.Task;
import java.io.Serializable;

/**
 * The Add class represents
 *
 */
public class Multiply implements Task<Double>, Serializable {
   
   private static final long serialVersionUID = 1L;

   private final double operand1;
   private final double operand2;

   public Multiply(double operand1, double operand2) {
      this.operand1 = operand1;
      this.operand2 = operand2;
   }

   @Override
   public Double execute() {
      return multiply(operand1, operand2);
   }

   public static Double multiply(double operand1, double operand2) {
      return operand1 * operand2;
   }

}
