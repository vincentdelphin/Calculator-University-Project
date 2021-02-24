package uk.ac.rhul.cs2800;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOpStack {


  Symbol leftBracket = Symbol.LEFT_BRACKET;
  Symbol rightBracket = Symbol.RIGHT_BRACKET;
  Symbol times = Symbol.TIMES;
  OpStack opstackTest;

  // Test 1
  // Testing to instantiation of OpStack an OpStack object.
  @BeforeEach
  void opStackSetUp() {
    opstackTest = new OpStack();
  }

  // Test 2
  // Pushing to opStack and checking if opStack is the correct size.
  @Test
  void testPush() {
    assertEquals(opstackTest.opStack.size(), 0,
        "No symbols have been pushed onto stack so size = 0");
    opstackTest.push(leftBracket);
    assertEquals(opstackTest.opStack.size(), 1,
        "One symbol has been pushed onto stack so size = 1");
  }

  // Test 3
  // Pushing to opStack and popping to make sure correct symbol is returned whilst making sure
  // the size of the stack changes accordingly.
  @Test
  void testPop() throws BadTypeExpo {
    opstackTest.push(leftBracket);
    assertEquals(opstackTest.opStack.size(), 1,
        "One symbol has been pushed onto stack so size = 1");
    assertEquals(opstackTest.pop(), leftBracket,
        "Expect leftBracket to be popped since it was pushed last.");
    assertEquals(opstackTest.opStack.size(), 0, "Only symbol in stack has been popped so size = 0");
    opstackTest.push(rightBracket);
    opstackTest.push(times);
    assertEquals(opstackTest.pop(), times, "Expect times to be popped since it was pushed last.");

  }

  // Test 4
  // Testing EmptyStackException is thrown when popping empty opStack.
  @Test
  void testEmptyStackException() {
    assertThrows(EmptyStackException.class, () -> opstackTest.pop());
  }

  // Test 5
  // Using the isEmpty method to check if opStack is empty before a symbol has been pushed and
  // checking it is not empty after a symbol has been pushed.
  @Test
  void testisEmpty() throws BadTypeExpo {
    assertEquals(opstackTest.isEmpty(), true,
        "Expect to be true since we haven't pushed any symbols to opstack.");
    opstackTest.push(leftBracket);
    opstackTest.push(times);
    assertEquals(opstackTest.isEmpty(), false,
        "Expect to be false since we just pushed leftBracket and times to opstack.");
    opstackTest.pop();
    opstackTest.pop();
    assertEquals(opstackTest.isEmpty(), true,
        "Expect to be true since we popped the pushed symbols from the opstack.");
    
    
    
  }
}

