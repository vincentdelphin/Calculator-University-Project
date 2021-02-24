package uk.ac.rhul.cs2800;

/**
 * Exception thrown when an invalid expression is passed through evaluate method in calculator.
 * 
 * @author Vincent
 *
 */
public class InvalidExpression extends Exception {

  private static final long serialVersionUID = 54959493248988929L;

  /**
   * Calls super class method to have getMessage method which is called when wrong expression is
   * passed through evaluate.
   * 
   */
  public InvalidExpression() {
    super("INVALID EXRPESSION");
  }
}
