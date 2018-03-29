package client;

import compute.Task;
import java.io.Serializable;

/**
 * The Add class represents
 *
 */
public class Subtract implements Task<Double>, Serializable {
   
   private static final long serialVersionUID = 1L;

   private final double operand1;
   private final double operand2;

   public Subtract(double operand1, double operand2) {
      this.operand1 = operand1;
      this.operand2 = this.operand1;
   }

   @Override
   public Double execute() {
      return subtract(operand1, operand2);
   }

   public static Double subtract(double operand1, double operand2) {
      return operand1 - operand2;
   }

}
