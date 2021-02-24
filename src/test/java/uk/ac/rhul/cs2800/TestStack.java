package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStack {

  Stack stack;
  Entry floatEntry;
  Entry symbolEntry;
  Entry stringEntry;

  // Creating the stack and entries where the first test but to avoid the
  // once and only once code smell, I introduced the initialisation them
  // them in a BeforeEach.
  @BeforeEach
  public void stackSetUp() {
    stack = new Stack();
    floatEntry = new Entry((float) 2.1);
    symbolEntry = new Entry(Symbol.LEFT_BRACKET);
    stringEntry = new Entry("3 +  4 * 2");
  }


  // Test 1
  // Created the size variable so I can return the size of the stack.
  @Test
  void testSize() {
    assertEquals(stack.size(), 0, "No entries have been pushed onto stack so size = 0");
  }

  // Test 2
  // pushing the float entry onto the stack, if it has been pushed onto
  // the stack then the stack should have 1 element which I test for below.
  @Test
  void testPush() {
    stack.push(floatEntry);
    assertEquals(stack.size(), 1, "1 entry pushed so there should be 1 item in stack.");

  }

  // Test 3
  // creating the pop method so I can return the entry on the top of the stack.
  // also used the emptystackexception because I know that the size is decremented by 1
  // every time I pop the stack, so if there are no entries then the size will be -1 which
  // will throw an error.
  @Test
  void testPopWithNoEntry() {
    assertThrows(EmptyStackException.class, () -> stack.pop());

  }

  // Test 4
  // Popping the stack to see if the value of the top of the stack
  // is stored correctly. Just tested the code to make sure the stack
  // works correctly.
  @Test
  void testPop() throws BadTypeExpo {
    stack.push(floatEntry);
    System.out.println(stack.size());
    assertEquals(stack.pop().getValue(), 2.1f, "231213");
  }

  // Test 5
  // Created the top method so I can view the element
  // on the top of the stack.
  @Test
  void testTop() throws BadTypeExpo {
    stack.push(floatEntry);
    stack.push(stringEntry);
    stack.push(symbolEntry);
    assertEquals(stack.top().getSymbol(), Symbol.LEFT_BRACKET,
        "Looking at last entry which is a left bracket.");
  }

  // Test 6
  // Combining the different methods together to make sure the stack works
  // pushed 3 entries and used the top to check they were ordered correctly.
  // Then popping the entries until we remove all elements. To ensure they are
  // removed correctly.
  @Test
  void testTopthenPopUntilError() throws BadTypeExpo {
    stack.push(floatEntry);
    stack.push(symbolEntry);
    stack.push(stringEntry);
    assertEquals(stack.top().getString(), "3 +  4 * 2",
        "Looking at last entry which is 3 +  4 * 2");
    stack.pop();
    stack.pop();
    stack.pop();
    assertEquals(stack.size(), 0, "We've popped all entries so size = 0");
    assertThrows(EmptyStackException.class, () -> stack.pop());
  }

  // Test 7
  // Wanted to test to make sure that if I was to view the top of the stack
  // but there was no entries in the stack, it throws an error. Initially, I did
  // not think about viewing the stack with no entries. Only considered viewing the
  // entry at the top.
  // So I added the badtype exception for when the size = 0.
  @Test
  void topError() throws BadTypeExpo {
    assertThrows(EmptyStackException.class, () -> stack.pop());
  }
}
