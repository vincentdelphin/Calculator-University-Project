package uk.ac.rhul.cs2800;

/**
 * Bad type exception to be thrown when wrong getter is called on entry.
 * 
 * @author Vincent
 *
 */
public class BadTypeExpo extends Exception {


  private static final long serialVersionUID = 2800L;

  /** Calls super class method to have getMessage method which is called when wrong getter is used.
   * 
   */
  public BadTypeExpo() {
    super("BADTYPE");
  }

}
