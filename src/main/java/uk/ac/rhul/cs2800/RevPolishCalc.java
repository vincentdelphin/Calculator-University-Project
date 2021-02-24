package uk.ac.rhul.cs2800;

/**
 * Calculates answer for expressions given in RevPolish form.
 * 
 * @author Vincent
 *
 */
public class RevPolishCalc implements Calculator {

  NumStack values;

  /**
   * Constructor for RevPolishCalc.
   * 
   */
  public RevPolishCalc() {
    values = new NumStack();
  }

  @Override
  public float evaluate(String what) throws BadTypeExpo, InvalidExpression {
    String[] tokens = what.split(" ");

    for (int i = 0; i < tokens.length; i++) {
      String string = tokens[i];
      if (Symbol.PLUS.toString().equals(string)) {
        values.push(values.pop() + values.pop());
      } else if (Symbol.MINUS.toString().equals(string)) {
        float firstValue = values.pop();
        float secondValue = values.pop();
        values.push(secondValue - firstValue);
      } else if (Symbol.DIVIDE.toString().equals(string)) {
        float firstValue = values.pop();
        float secondValue = values.pop();
        values.push(secondValue / firstValue);
      } else if (Symbol.TIMES.toString().equals(string)) {
        values.push(values.pop() * values.pop());
      } else {
        values.push(Float.parseFloat(tokens[i]));
      }
    }
    return values.pop();
  }
}
