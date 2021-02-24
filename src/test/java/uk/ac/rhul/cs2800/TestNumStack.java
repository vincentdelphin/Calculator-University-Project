package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNumStack {

  // Testing to instantiate a NumStack.
  NumStack numberStack;

  @BeforeEach
  void numStackSetUp() {
    numberStack = new NumStack();
  }

  // Test 2
  // Pushing two float elements onto stack, testing the size increments after each float is pushed.
  @Test
  void testPush() {
    numberStack.push(3.5f);
    assertEquals(numberStack.numStack.size(), 1,
        "One float has been pushed onto stack so size = 1");

    numberStack.push(3.5f);
    assertEquals(numberStack.numStack.size(), 2,
        "Two floats have been pushed onto stack so size = 2");

  }

  // Test 3
  // Popping elements after they are pushed onto stack to make sure last in first out.
  // Has to throw a bad type exception since the pop method uses getValue.
  @Test
  void testPop() throws BadTypeExpo {
    numberStack.push(2.23f);
    numberStack.push(3213.f);
    numberStack.push(231.43f);

    assertEquals(numberStack.pop(), 231.43f,
        "Last float to be inputted is 231.43f so we expect it to be the first to be popped.");

    assertEquals(numberStack.pop(), 3213.f,
        "Second last float to be inputted is 3213.f so we expect it to be the next to be popped.");

    assertEquals(numberStack.pop(), 2.23f,
        "First float to be inputted is 2.23f so we expect it to be the next to be popped.");


  }

  // Test 4
  // Testing to see if a EmptyStackException is thrown if I pop the numStack without pushing any
  // floats.
  @Test
  void testEmptyStackException() {
    assertThrows(EmptyStackException.class, () -> numberStack.pop());
  }


  // Test 5
  // Using the isEmpty method to make sure it returns the correct
  // value dependent on if we've pushed to the stack or not.
  @Test
  void testisEmpty() {
    assertEquals(numberStack.isEmpty(), true,
        "Expect to be true since we haven't pushed any floats to numstack.");
    numberStack.push(24.5f);
    assertEquals(numberStack.isEmpty(), false,
        "Expect to be false since we just pushed 24.5 to numstack.");

  }
}
