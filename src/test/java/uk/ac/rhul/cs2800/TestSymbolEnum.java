package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import org.junit.jupiter.api.Test;

class TestSymbolEnum {

  // Test 1
  @SuppressWarnings({"unchecked", "static-access"})
  @Test
  public void symbolTest() {
    // the idea here is to create a set so we can append all the
    // enums created in Symbol. If these enums are correctly
    // added to the hashSet, we should be able to get the
    // same size of the hashSet == number of Symbol enums.
    // SuppressWarnings were flagged for quick fixes so I added them since
    // we are using a raw type of hashSet.
    @SuppressWarnings("rawtypes")
    HashSet settoStoreSymbols = new HashSet();

    for (uk.ac.rhul.cs2800.Symbol symbol : Symbol.values()) {
      settoStoreSymbols.add(symbol.values());
    }
    assertEquals(settoStoreSymbols.size(), 7, "If 7 enums there should be 7 enums in the set.");
  }

  // Test 2
  @Test
  public void toStringTest() {
    // Instantiating Symbol enums for testing, variable name is same as instantiated enum.
    // So when we test them, we can know what Symbol is represented in enum since the
    // variable name is the same.
    Symbol leftBracket = Symbol.LEFT_BRACKET;
    Symbol rightBracket = Symbol.RIGHT_BRACKET;
    Symbol times = Symbol.TIMES;
    // Testing toString method on enum types.
    assertEquals(leftBracket.toString(), "(", "Test toString for left bracket enum.");
    assertEquals(rightBracket.toString(), ")", "Test toString for right bracket enum.");
    assertEquals(times.toString(), "*", "Test toString for times enum.");

    // a repeat of above.

    Symbol divide = Symbol.DIVIDE;
    Symbol plus = Symbol.PLUS;
    Symbol minus = Symbol.MINUS;


    assertEquals(divide.toString(), "/", "Test toString for divide enum.");
    assertEquals(plus.toString(), "+", "Test toString for plus enum.");
    assertEquals(minus.toString(), "-", "Test toString for minus enum.");


    Symbol invalid = Symbol.INVALID;
    assertEquals(invalid.toString(), "INVALID", "Test toString for invalid enum.");
  }

}
