package uk.ac.rhul.cs2800;

/**
 * Shows calculator's memories.
 * 
 * @author Vincent
 *
 */

public class CalcModel {

  RevPolishCalc revPolishCalc;
  StandardCalc standardCalc;
  boolean isInfix;


  /**
   * Constructor for CalcModel class.
   * 
   */
  public CalcModel() {
    revPolishCalc = new RevPolishCalc();
    standardCalc = new StandardCalc();
  }


  /**
   * Evaluates either infix or postfix expression.
   * 
   * @param expr expression to be evaluated.
   * @param isInfix is true dependent on of the expression given is in infix notation.
   * @return answer to expression to be evaluated.
   * @throws InvalidExpression thrown if expression given is invalid.
   * @throws BadTypeExpo thrown if getter is incorrect in evaluate method
   */
  public float evaluate(String expr, boolean isInfix) throws BadTypeExpo, InvalidExpression {
    if (isInfix == true) {
      return standardCalc.evaluate(expr);
    } else {
      return revPolishCalc.evaluate(expr);
    }
  }

}
