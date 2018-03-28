package edu.psu.ist411.client;

import edu.psu.ist411.compute.Task;
import java.io.Serializable;

/**
 * The Add class represents
 *
 */
public class Add implements Task<Double>, Serializable {

   private final double operand1;
   private final double operand2;

   public Add(double operand1, double operand2) {
      this.operand1 = operand1;
      this.operand2 = this.operand1;
   }

   @Override
   public Double execute() {
      return add(operand1, operand2);
   }

   public static Double add(double operand1, double operand2) {
      return operand1 + operand2;
   }

}
