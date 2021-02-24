package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestEntry {

  // instantiating entry objects with the respective names
  Entry floatEntry; // float entry for a float to be passed to constructor.
  Entry symbolEntry; // symbol entry for a symbol to be passed to constructor.
  Entry stringEntry; // string entry for a string to be passed to constructor.

  // Test 1
  @BeforeEach
  public void setUp() {
    // creating the entries where the first test but to avoid the
    // once and only once code smell, I introduced the initialisation of
    // them in a BeforeEach.
    floatEntry = new Entry(2.1f);
    symbolEntry = new Entry(Symbol.LEFT_BRACKET);
    stringEntry = new Entry("3 +  4 * 2");
  }

  // Test 2
  @Test
  void instantiateDifferentEntries() throws BadTypeExpo {
    // We want to see if the constructors instantiate the correct type for the desired input:
    // added getters for symbol, number and string variables.
    // i.e. string entry is a type of String etc.
    assertEquals(symbolEntry.getType(), Type.SYMBOL,
        "Checks if the Symbol SYMBOL is assigned to symbol input - left bracket");
    assertEquals(floatEntry.getType(), Type.NUMBER,
        "Checks if the Symbol NUMBER is assigned to float input - 2.1f");
    assertEquals(stringEntry.getType(), Type.STRING,
        "Checks if the Symbol STRING is assigned to string input - 3 + 4 * 2");
  }

  // Test 3
  @Test
  public void exceptionsThrownforBadType() {
    // Must make exception for getType, symbol, string, float if called on entry with no such value.
    // I created a BadType exception to be thrown in the event the wrong getter is called.
    BadTypeExpo e = assertThrows(BadTypeExpo.class, () -> floatEntry.getString());
    assertEquals(e.getMessage(), "BADTYPE");
    BadTypeExpo e1 = assertThrows(BadTypeExpo.class, () -> symbolEntry.getValue());
    assertEquals(e1.getMessage(), "BADTYPE");
    BadTypeExpo e3 = assertThrows(BadTypeExpo.class, () -> stringEntry.getSymbol());
    assertEquals(e3.getMessage(), "BADTYPE");
    // Exceptions are thrown for when we do not have the correct getter for the relevant entry!
  }


}
