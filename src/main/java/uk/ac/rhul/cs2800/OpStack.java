package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * OpStack class to store float entries from the user.
 * 
 * @author Vincent
 *
 */

public class OpStack {

  Stack opStack;

  /**
   * Constructor for OpStack class.
   * 
   */

  public OpStack() {
    opStack = new Stack();
  }

  /**
   * Push method to add symbol onto stack.
   * 
   * @param i symbol to be pushed onto stack.
   */

  public void push(Symbol i) {
    opStack.push(new Entry(i));

  }

  /**
   * Returns the symbol from top of opStack.
   * 
   * @return symbol from top of opStack.
   * @throws BadTypeExpo thrown when getValue() is used to return anything else except a symbol.
   */
  public Symbol pop() throws BadTypeExpo {
    if (opStack.size() == 0) {
      throw new EmptyStackException();
    }
    return opStack.pop().getSymbol();
  }


  /**
   * Checks if opStack is empty.
   * 
   * @return true or false dependent on if opStack is empty or not.
   */
  public boolean isEmpty() {
    if (opStack.size() == 0) {
      return true;
    } else {
      return false;
    }


  }


}

