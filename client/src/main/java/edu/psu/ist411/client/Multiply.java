package edu.psu.ist411.client;

import edu.psu.ist411.compute.Task;
import java.io.Serializable;

/**
 * The Add class represents
 *
 */
public class Multiply implements Task<Double>, Serializable {

   private final double operand1;
   private final double operand2;

   public Multiply(double operand1, double operand2) {
      this.operand1 = operand1;
      this.operand2 = this.operand1;
   }

   @Override
   public Double execute() {
      return multiply(operand1, operand2);
   }

   public static Double multiply(double operand1, double operand2) {
      return operand1 * operand2;
   }

}
