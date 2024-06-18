package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.Number;
import edu.austral.ingsis.math.Variable;
import edu.austral.ingsis.math.operations.*;

public class PrintVisitor implements Visitor<String> {

  @Override
  public String visit(Addition addition) {
    return "(" + addition.getLeft().accept(this) + " + " + addition.getRight().accept(this) + ")";
  }

  @Override
  public String visit(Subtraction subtraction) {
    return "("
        + subtraction.getLeft().accept(this)
        + " - "
        + subtraction.getRight().accept(this)
        + ")";
  }

  @Override
  public String visit(Multiplication multiplication) {
    return "("
        + multiplication.getLeft().accept(this)
        + " * "
        + multiplication.getRight().accept(this)
        + ")";
  }

  @Override
  public String visit(Division division) {
    return "("
        + division.getDividend().accept(this)
        + " / "
        + division.getDivisor().accept(this)
        + ")";
  }

  @Override
  public String visit(Power power) {
    return "(" + power.getBase().accept(this) + " ^ " + power.getExponent().accept(this) + ")";
  }

  @Override
  public String visit(SquareRoot squareRoot) {
    return "sqrt(" + squareRoot.getFunction().accept(this) + ")";
  }

  @Override
  public String visit(AbsoluteValue absoluteValue) {
    return "|" + absoluteValue.getFunction().accept(this) + "|";
  }

  @Override
  public String visit(Number number) {
    return String.valueOf(number.getValue());
  }

  @Override
  public String visit(Variable variable) {
    return variable.getName();
  }
}
