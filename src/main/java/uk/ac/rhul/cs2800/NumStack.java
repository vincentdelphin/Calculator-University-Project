package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * Number stack class to store float entries from user.
 * 
 * @author Vincent
 *
 */
public class NumStack {

  Stack numStack;

  /**
   * Constructor for NumStack class.
   * 
   */

  public NumStack() {
    numStack = new Stack();
  }

  /**
   * Places user input of type float onto stack.
   * 
   * @param i float to be pushed onto stack.
   */
  public void push(float i) {
    numStack.push(new Entry(i));
  }

  /**
   * Returns the float value from numStack.
   * 
   * @return value from top of NumStack.
   * @throws BadTypeExpo thrown when getValue() is used to return anything else except a float.
   */
  public Float pop() throws BadTypeExpo {
    if (numStack.size() == 0) {
      throw new EmptyStackException();
    }
    return numStack.pop().getValue();

  }

  /**
   * Checks if NumStack is empty.
   * 
   * @return boolean dependent on if stack is empty or not.
   */
  public Boolean isEmpty() {
    if (numStack.size() == 0) {
      return true;
    } else {
      return false;
    }
  }


}
