package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Stack class to store entries from the user.
 * 
 * @author Vincent
 *
 */
public class Stack {

  public int size;
  List<Entry> entries;

  /**
   * Constructor for stack class.
   * 
   */
  public Stack() {
    entries = new ArrayList<Entry>();
    size = 0;
  }

  /**
   * Gets the size of stack.
   * 
   * @return size
   */
  public int size() {
    return size;
  }


  /**
   * Pushes entry onto stack.
   * 
   * @param entry type to be pushed onto stack.
   */
  public void push(Entry entry) {
    size++;
    this.entries.add(entry);

  }


  /**
   * Pops entry from stack.
   * 
   * @return the entry object at the top of the stack
   */
  public Entry pop() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    Entry entrytoBePopped = this.entries.get(size() - 1);
    this.entries.remove(size() - 1);
    size = size - 1;
    return entrytoBePopped;
  }


  /**
   * Peeks at last entry added without popping.
   * 
   * @return the entry object at top of the stack
   */
  public Entry top() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return entries.get(size - 1);
  }



}
