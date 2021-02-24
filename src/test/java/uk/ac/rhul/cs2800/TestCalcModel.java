package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcModel {


  CalcModel calculator;

  // Initialising CalcModels.
  @BeforeEach
  void InstantiatingCalcModel() {
    calculator = new CalcModel();
  }

  // Evaluating simple expression given in infix.
  @Test
  void firstExpressionTest() throws BadTypeExpo, InvalidExpression {
    assertEquals(calculator.evaluate("1 + 1", true), 2, "1 + 1 = 2 so we expect 2 to be returned.");
  }
  

  // Evaluating simple expression given is not in infix.
  @Test
  void secondExpressionTest() throws BadTypeExpo, InvalidExpression {
    assertEquals(calculator.evaluate("1 1 +", false), 2, "1 + 1 = 2 so we expect 2 to be returned.");
  }
}
