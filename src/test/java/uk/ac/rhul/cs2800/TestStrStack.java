package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStrStack {

  // Test to instantiate a StrStack.
  StrStack stringStack;

  @BeforeEach
  void strStackSetUp() {
    stringStack = new StrStack();
  }

  // Test 2
  // Pushing to StrStack and checking if StrStack is the correct size.
  @Test
  void testPush() {
    assertEquals(stringStack.strStack.size(), 0,
        "No symbpols have been pushed onto stack so size = 0");
    stringStack.push("5 + 3");
    stringStack.push("5 + 3");
    assertEquals(stringStack.strStack.size(), 2,
        "Two string expressions have been pushed onto stack so size = 2");
  }


  // Test 3
  // Pushing to StrStack and popping to make sure correct string expression is returned whilst
  // making sure the size of the stack changes accordingly.
  @Test
  void testPop() throws BadTypeExpo {
    stringStack.push("5 + 3");
    assertEquals(stringStack.strStack.size(), 1,
        "One string expression has been pushed onto stack so size = 1");
    assertEquals(stringStack.pop(), "5 + 3",
        "Expect 5 + 3 expression to be popped since it was pushed last.");
    assertEquals(stringStack.strStack.size(), 0,
        "Only string expression in stack has been popped so size = 0");
    stringStack.push("");
    stringStack.push("9 * 7");
    stringStack.pop();
    assertEquals(stringStack.pop(), "",
        "Expect the empty expression to be popped since it was pushed last.");
  }


  // Test 4
  // Testing EmptyStackException is thrown when popping empty strStack.
  @Test
  void testEmptyStackException() {
    assertThrows(EmptyStackException.class, () -> stringStack.pop());
  }


  // Test 5
  // Using isEmpty method to check that StrStack is not empty after string has been pushed.
  @Test
  void testisEmptyFalse() {
    stringStack.push("94 * 37");
    assertEquals(stringStack.isEmpty(), false,
        "Expect to be false since we just pushed 97 * 37 to the stringStack.");
  }
  

  // Test 6
  // Using isEmpty method to check that StrStack is since nothing has been pushed.
  @Test
  void testisEmptyTrue() {
    assertEquals(stringStack.isEmpty(), true,
        "Expect to be true since nothing has been pushed to the stringStack.");
  }

}
