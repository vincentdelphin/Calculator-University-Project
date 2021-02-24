package uk.ac.rhul.cs2800;

/**
 * Calculates answer for expressions given in standard infix form.
 * 
 * 
 * @author Vincent
 *
 */
public class StandardCalc implements Calculator {
  RevPolishCalc rpCalc;

  /**
   * Constructor for standard calculator.
   */
  public StandardCalc() {
    rpCalc = new RevPolishCalc();
  }

  /**
   * Returns precedence level which is dependent on character passed through.
   * 
   * @param ch symbol to find precedence.
   * @return integer of precedence (1 for +,- and 2 for /,* )
   */

  public static int getPrecedence(char ch) {
    // We want to check the precedence of character to determine what operations we should do in
    // evaluate.
    String character = Character.toString(ch);
    if (character == Symbol.PLUS.toString() || character == Symbol.MINUS.toString()) {
      return 1;
    } else if (character == Symbol.TIMES.toString() || character == Symbol.DIVIDE.toString()) {
      return 2;
    }
    return -1;
  }

  /**
   * Returns true if character is a digit or a character.
   * 
   * @param c character to be evaluated.
   * @return boolean dependent on if character or digit is passed through.
   */
  private static boolean isDigitorCharacter(char c) {
    if (Character.isLetterOrDigit(c)) {
      return true;
    } else {
      return false;
    }
  }


  /**
   * Converts infix notation to postfix notation to be evaluated.
   * 
   * @param string expression to be converted.
   * @return infix expression in postfix notation.
   */
  public String infixToReversePolish(String string) {
    // using the standard stack type from java.util to store inputs.
    java.util.Stack<Character> stack = new java.util.Stack<>();

    String output = new String("");

    for (int i = 0; i < string.length(); ++i) {
      char c = string.charAt(i);


      if (isDigitorCharacter(c)) {
        output += c;
      } else if (Character.toString(c) == Symbol.LEFT_BRACKET.toString()) {
        stack.push(c);
      } else if (Character.toString(c) == Symbol.RIGHT_BRACKET.toString()) {
        // keep popping until left hand bracket is found.
        while (!stack.isEmpty()
            && Character.toString(stack.peek()) != Symbol.LEFT_BRACKET.toString()) {
          output += stack.pop();

          stack.pop();
        }
      } else {
        while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {


          output += stack.pop();
        }
        stack.push(c);
      }
    }
    // seeing if the character stack is empty.
    while (!stack.isEmpty()) {
      if (Character.toString(stack.peek()) == Symbol.LEFT_BRACKET.toString()) {
        return "This expression is invalid";
      }
      output += stack.pop();
    }
    return output;
  }


  @Override
  public float evaluate(String what) throws InvalidExpression, BadTypeExpo {

    // need to convert spaced input to no spaces.
    String whatWithNoSpaces = what.replaceAll("\\s+", "");

    String input = infixToReversePolish(whatWithNoSpaces);

    StringBuilder string = new StringBuilder(String.valueOf(input.charAt(0)));


    for (int i = 1; i < input.length(); i++) {
      string.append(" ").append(input.charAt(i));
    }

    return rpCalc.evaluate(string.toString());
  }


}
