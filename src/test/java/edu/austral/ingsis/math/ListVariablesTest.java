package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.operations.*;
import edu.austral.ingsis.math.visitors.ListingVisitor;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  private final ListingVisitor visitor = new ListingVisitor();

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    Addition total = new Addition(new Number(1), new Number(6));
    final List<String> result = visitor.visit(total);

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    Division total = new Division(new Number(12), new Variable("div"));
    final List<String> result = visitor.visit(total);
    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    Multiplication total =
        new Multiplication(new Division(new Number(9), new Variable("x")), new Variable("y"));
    final List<String> result = visitor.visit(total);

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    Power total = new Power(new Division(new Number(27), new Variable("a")), new Variable("b"));
    final List<String> result = visitor.visit(total);

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    Power total = new Power(new Variable("z"), new Division(new Number(1), new Number(2)));
    final List<String> result = visitor.visit(total);

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    Subtraction total = new Subtraction(new AbsoluteValue(new Variable("value")), new Number(8));
    final List<String> result = visitor.visit(total);

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    Subtraction total = new Subtraction(new AbsoluteValue(new Variable("value")), new Number(8));
    final List<String> result = visitor.visit(total);

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    Multiplication total =
        new Multiplication(new Subtraction(new Number(5), new Variable("i")), new Number(8));
    final List<String> result = visitor.visit(total);

    assertThat(result, containsInAnyOrder("i"));
  }
}
