package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operations.*;
import edu.austral.ingsis.math.visitors.PrintVisitor;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

  final PrintVisitor visitor = new PrintVisitor();

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "(1.0 + 6.0)";

    Addition addition = new Addition(new Number(1), new Number(6));
    final String result = visitor.visit(addition);

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "(12.0 / 2.0)";

    Division division = new Division(new Number(12), new Number(2));
    final String result = visitor.visit(division);

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "((9.0 / 2.0) * 3.0)";

    Multiplication function = new Multiplication(new Division(new Number(9), new Number(2)), new Number(3));
    final String result = visitor.visit( function);

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "((27.0 / 6.0) ^ 2.0)";
    Power power = new Power(new Division(new Number(27), new Number(6)), new Number(2));
    final String result = visitor.visit(power);


    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "(|value| - 8.0)";
    Subtraction subtraction = new Subtraction(new AbsoluteValue(new Variable("value")), new Number(8));
    final String result = visitor.visit(subtraction);

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "(|value| + 8.0)";
    Addition addition = new Addition(new AbsoluteValue(new Variable("value")), new Number(8));
    final String result = visitor.visit(addition);

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "((5.0 - i) * 8.0)";
    Multiplication multiplication = new Multiplication(new Subtraction(new Number(5), new Variable("i")), new Number(8));
    final String result = visitor.visit(multiplication);

    assertThat(result, equalTo(expected));
  }
  @Test
  public void shouldPrintSqRoot() {
    final String expected = "sqrt(5.0)";
    SquareRoot squareRoot = new SquareRoot(new Number(5));
    final String result = visitor.visit(squareRoot);

    assertThat(result, equalTo(expected));
  }
}
