package uk.ac.rhul.cs2800;

/**
 * Symbol enumeration types.
 * 
 * @author Vincent
 *
 */

public enum Symbol {
  LEFT_BRACKET("("), RIGHT_BRACKET(")"), TIMES("*"), DIVIDE("/"), PLUS("+"), MINUS("-"), INVALID(
      "INVALID");


  private String symbol;

  /**
   * Constructor for symbols.
   * 
   * @param inputsymbol to match string to symbol
   */
  Symbol(String inputsymbol) {
    this.symbol = inputsymbol;
  }

  /**
   * Getter for Symbol enum.
   * 
   * @return symbol return the symbol represented by enum.
   */
  public String toString() {
    return symbol;
  }


}
