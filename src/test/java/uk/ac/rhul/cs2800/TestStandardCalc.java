package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStandardCalc {

  StandardCalc calculator;

  // StandardCalc instantiation test.
  @BeforeEach
  void calculatorSetUp() {
    calculator = new StandardCalc();
  }

  // Evaluating simple expression given in correct infix Notation.
  @Test
  void firstExpressionTest() throws InvalidExpression, BadTypeExpo {
    assertEquals(calculator.evaluate("1 + 1"), 2, "1 + 1 = 2 so we expect 2 to be returned.");
  }


  // Evaluating more complex addition expression given in correct infix Notation.
  @Test
  void secondExpressionTest() throws InvalidExpression, BadTypeExpo {
    assertEquals(calculator.evaluate("1 + 1 + 5"), 7, "1 + 1 + 5 = 7 so we expect 7 to be returned.");
  }
  
  // Evaluating simple subtraction given in correct infix Notation.
  @Test
  void thirdExpressionTest() throws InvalidExpression, BadTypeExpo {
    assertEquals(calculator.evaluate("1 - 1"), 0, "1 - 1 = 0 so we expect 0 to be returned.");
  }
  
  // Evaluating complex subtraction given in correct infix Notation.
  @Test
  void fourthExpressionTest() throws InvalidExpression, BadTypeExpo {
    assertEquals(calculator.evaluate("0 - 1 - 5 "), -6 , "0 - 1 = -6 so we expect -1 to be returned.");
  }
  

  // Evaluating simple multiplication given in correct infix Notation.
  @Test
  void fifthExpressionTest() throws InvalidExpression, BadTypeExpo {
    assertEquals(calculator.evaluate("3 * 6 "), 18, "3 * 6 = 18 so we expect 18 to be returned.");
  }

  // Evaluating complex subtraction given in correct infix Notation.
  @Test
  void sixthExpressionTest() throws InvalidExpression, BadTypeExpo {
    assertEquals(calculator.evaluate("3 * 6 * 9"), 162, "3 * 6 * 9 = 162 so we expect 162 to be returned.");
  }
  
  // Evaluating simple division given in correct infix Notation.
  @Test
  void seventhExpressionTest() throws InvalidExpression, BadTypeExpo {
    assertEquals(calculator.evaluate("9 / 3"), 3, "9 / 3 = 3  so we expect 6.3f to be returned.");
  }
  

  // Evaluating simple division given in correct infix Notation.
  @Test
  void eigthExpressionTest() throws InvalidExpression, BadTypeExpo {
    assertEquals(calculator.evaluate("9 / 3 / 2"), 1.5f, "9 / 3 / 2 = 1.5  so we expect 1.5f to be returned.");
  }
  
  // Evaluating  mix of multiplication and division given in correct infix Notation.
  @Test
  void ninthExpressionTest() throws InvalidExpression, BadTypeExpo {
    assertEquals(calculator.evaluate("9 * 3 / 2"), 13.5f, "9 * 3 / 2 = 13.5  so we expect 13.5f to be returned.");
  }
  
  // Evaluating  mix of multiplication and division given in correct infix Notation.
  @Test
  void tenthExpressionTest() throws InvalidExpression, BadTypeExpo {
    assertEquals(calculator.evaluate("9/2 * 3 + 2"), 15.5f, "9 / 2 * 3 + 2 = 15.5  so we expect 15.5f to be returned.");
  }
}
