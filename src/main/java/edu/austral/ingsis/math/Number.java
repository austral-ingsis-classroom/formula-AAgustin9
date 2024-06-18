package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitors.Visitor;

public class Number implements Function {

  private final double value;

  public Number(double value) {
    this.value = value;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }

  public double getValue() {
    return value;
  }
}
