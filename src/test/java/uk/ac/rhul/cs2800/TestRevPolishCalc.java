package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class TestRevPolishCalc {

  RevPolishCalc calculator;

  // RevPolishCalc instantiation test.
  @BeforeEach
  void calculatorSetUp() {
    calculator = new RevPolishCalc();
  }

 

  // Evaluating more complex version of expression used above. Given in correct Reverse Polish
  // Notation.
  @Test
  void secondExpressionTest() throws InvalidExpression, BadTypeExpo {
    assertEquals(calculator.evaluate("1 1 2 + +"), 4,
        "1 + 1 + 2 = 3 so we expect 4 to be returned.");

  }

  // Evaluating simple expression with subtraction in correct Reverse Polish Notation.
  @Test
  void thirdExpressionTest() throws InvalidExpression, BadTypeExpo {
    assertEquals(calculator.evaluate("2 1 -"), 1, "2 - 1 = 0 so we expect 1 to be returned.");

  }

  // Evaluating expression with both subtraction and minus.
  @Test
  void fourthExpressionTest() throws InvalidExpression, BadTypeExpo {
    assertEquals(calculator.evaluate("2 1 - 3 +"), 4,
        "2 - 1 + 3 = 4 so we expect 1 to be returned.");

  }

  // Evaluating simple expression with divide.
  @Test
  void fifthExpressionTest() throws InvalidExpression, BadTypeExpo {
    assertEquals(calculator.evaluate("1 1 /"), 1, "1 / 1 = 1 so we expect 1 to be returned.");

  }

  // Evaluating complex expression with divide and addition.
  @Test
  void sixthExpressionTest() throws InvalidExpression, BadTypeExpo {
    assertEquals(calculator.evaluate("1 2 5 / +"), 1.4f, "1 + 2 / 5 so we expect 1.4 to be returned.");

  }
  
  //Testing multiplication.
  @Test
  void seventhExpressionTest() throws InvalidExpression, BadTypeExpo{
    assertEquals(calculator.evaluate("2 3.23 * "), 6.46f, "2 * 3.23 = 6.46 so we expect 6.46f to be returned.");
  }
}
