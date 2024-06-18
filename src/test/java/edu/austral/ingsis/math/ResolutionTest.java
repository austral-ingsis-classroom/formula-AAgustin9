package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operations.*;
import edu.austral.ingsis.math.visitors.SolveVisitor;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResolutionTest {

  private final SolveVisitor visitor = new SolveVisitor();

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    final Double result = 7d;
    Addition addition = new Addition(new Number(1), new Number(6));
    Double actual = addition.accept(visitor);

    assertThat(actual, equalTo(result));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    final Double result = 6d;
    Division division = new Division(new Number(12), new Number(2));
    Double actual = division.accept(visitor);

    assertThat(actual, equalTo(result));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    final Double result = 13.5;
    Multiplication multiplication = new Multiplication(new Division(new Number(9), new Number(2)), new Number(3));
    Double actual = multiplication.accept(visitor);

    assertThat(actual, equalTo(result));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    final Double result = 20.25;
    Power power = new Power(new Division(new Number(27), new Number(6)), new Number(2));
    Double actual = power.accept(visitor);

    assertThat(actual, equalTo(result));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    final Double result = 6d;
    Power power = new Power(new Number(36), new Division(new Number(1), new Number(2)));
    Double actual = power.accept(visitor);

    assertThat(actual, equalTo(result));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    final Double result = 136d;
    AbsoluteValue abs = new AbsoluteValue(new Number(136));
    Double actual = abs.accept(visitor);

    assertThat(actual, equalTo(result));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    final Double result = 136.d;
    AbsoluteValue abs = new AbsoluteValue(new Number(-136));
    Double actual = abs.accept(visitor);

    assertThat(actual, equalTo(result));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final Double result = 0d;
    Multiplication multiplication = new Multiplication(new Subtraction(new Number(5), new Number(5)), new Number(8));
    Double actual = multiplication.accept(visitor);

    assertThat(actual, equalTo(result));
  }
}
