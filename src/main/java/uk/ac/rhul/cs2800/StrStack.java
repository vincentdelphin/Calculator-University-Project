package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * StrStack class to store string entries from the user.
 * 
 * 
 * @author Vincent
 *
 */
public class StrStack {
  Stack strStack;

  /**
   * Constructor for StrStack class.
   * 
   */
  public StrStack() {
    strStack = new Stack();
  }

  /**
   * Push method to add string onto stack.
   * 
   * @param str string expression to be pushed onto stack.
   */
  public void push(String str) {
    strStack.push(new Entry(str));
  }

  /**
   * Returns the string from top of opStack.
   * 
   * @return string expression from top of strStack.
   * @throws BadTypeExpo thrown when getString() is used to return anything else except a string.
   */
  public String pop() throws BadTypeExpo {
    if (strStack.size() == 0) {
      throw new EmptyStackException();
    }
    return strStack.pop().getString();
  }

  /**
   * Checks if strStack is empty.
   * 
   * @return true or false dependent on if the strStack is empty or not.
   */
  public Object isEmpty() {
    if (strStack.size() == 0) {
      return true;
    } else {
      return false;
    }
  }



}
