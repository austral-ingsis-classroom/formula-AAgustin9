package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operations.*;
import edu.austral.ingsis.math.visitors.SolveVisitor;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  private final Map<String, Number> varMap =
      Map.of(
          "x", new Number(3.0),
          "div", new Number(4.0),
          "y", new Number(4.0),
          "a", new Number(9.0),
          "b", new Number(3.0),
          "z", new Number(36.0),
          "value", new Number(8.0),
          "i", new Number(2.0));

  private final SolveVisitor visitor = new SolveVisitor(varMap);

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    final Double result = 4d;
    Addition addition = new Addition(new Number(1), new Variable("x"));
    Double actual = visitor.visit(addition);

    assertThat(actual, equalTo(result));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final Double result = 3d;
    Division division = new Division(new Number(12), new Variable("div"));
    Double actual = visitor.visit(division);

    assertThat(actual, equalTo(result));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    final Double result = 12d;
    Multiplication multiplication =
        new Multiplication(new Division(new Number(9), new Variable("x")), new Variable("y"));
    Double actual = visitor.visit(multiplication);

    assertThat(actual, equalTo(result));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    final Double result = 27d;
    Power power = new Power(new Division(new Number(27), new Variable("a")), new Variable("b"));
    Double actual = visitor.visit(power);

    assertThat(actual, equalTo(result));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    final Double result = 6d;
    Power power = new Power(new Variable("z"), new Division(new Number(1), new Number(2)));
    Double actual = visitor.visit(power);

    assertThat(actual, equalTo(result));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final Double result = 0d;
    Subtraction sub = new Subtraction(new AbsoluteValue(new Variable("value")), new Number(8));
    Double actual = visitor.visit(sub);

    assertThat(actual, equalTo(result));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    final Double result = 0d;
    Subtraction sub = new Subtraction(new AbsoluteValue(new Variable("value")), new Number(8));
    Double actual = visitor.visit(sub);

    assertThat(actual, equalTo(result));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    final Double result = 24d;
    Multiplication multiplication =
        new Multiplication(new Subtraction(new Number(5), new Variable("i")), new Number(8));
    Double actual = visitor.visit(multiplication);

    assertThat(actual, equalTo(result));
  }
}
