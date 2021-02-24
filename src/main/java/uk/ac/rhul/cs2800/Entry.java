package uk.ac.rhul.cs2800;

import java.util.Objects;

/**
 * Converts inputs to relevant entry for the stack.
 * 
 * @author Vincent
 */
public class Entry {

  // I changed the variable name from number to value since
  // getter is called getValue in UML diagram given.
  float value;
  Symbol other;
  String str;
  Type type = Type.INVALID;
  // default type given to the type before it is instantiated.
  // in the event an entry is made with an invalid argument.
  // get type returns INVALID the argument given to make entry is invalid.

  /**
   * Entry for float input by user.
   * 
   * @param value of type float inputed by the user
   */
  public Entry(float value) {
    this.value = value;
    this.type = Type.NUMBER;
  }

  /**
   * Entry for symbol input by user.
   * 
   * @param other of type symbol inputed by the user
   */
  public Entry(Symbol other) {
    this.other = other;
    this.type = Type.SYMBOL;
  }

  /**
   * Entry for string inputs by the user.
   * 
   * @param str string input by the user.
   */
  public Entry(String str) {
    this.str = str;
    this.type = Type.STRING;
  }

  // the following methods return the correct attributes to the correct entries.
  // e.g. a symbol entry will have a symbol getter, if we are to have a string entry
  // and try to get the value, there will be no value since the constructor only takes
  // 1 type of argument, so we throw a BadTypeexception.

  /**
   * Symbol getter for symbol entry.
   * 
   * @return the symbol of entry
   * @throws BadTypeExpo when wrong getter is used on incompatible entry
   */
  public Symbol getSymbol() throws BadTypeExpo {
    if (other == null) {
      throw new BadTypeExpo();
    }
    return other;
  }

  /**
   * Value getter for float entry.
   * 
   * @return value the value of entry
   * @throws BadTypeExpo when wrong getter is used on incompatible entry
   */
  public float getValue() throws BadTypeExpo {
    if (str != null || other != null || Float.isNaN(this.value)) {
      throw new BadTypeExpo();
    }
    return value;
  }

  /**
   * String getter for string entry.
   * 
   * @return the string of entry
   * @throws BadTypeExpo when wrong getter is used on incompatible entry
   */
  public String getString() throws BadTypeExpo {
    if (str == null) {
      throw new BadTypeExpo();
    }
    return str;
  }

  /**
   * Getter for Type variable of entry.
   * 
   * @return type returns the type of enum of the entry given.
   * 
   * @throws BadTypeExpo when wrong getter is used on incompatible entry
   */
  public final Type getType() throws BadTypeExpo {
    if (type == Type.INVALID) {
      throw new BadTypeExpo();
    }
    return type;
  }


  @Override
  public int hashCode() {
    return Objects.hash(str, type);
  }

  // overriding equals as it is standard to override when hashCode is also being
  // overridden.

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Entry)) {
      return false;
    }
    Entry other = (Entry) obj;
    return Objects.equals(str, other.str) && type == other.type;
  }



}
