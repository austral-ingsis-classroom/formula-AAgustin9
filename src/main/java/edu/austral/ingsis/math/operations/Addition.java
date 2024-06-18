package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitors.Visitor;

public class Addition implements Function {

  private final Function left;
  private final Function right;

  public Addition(Function left, Function right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }

  public Function getLeft() {
    return left;
  }

  public Function getRight() {
    return right;
  }
}
