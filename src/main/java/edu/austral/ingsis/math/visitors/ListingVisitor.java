package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.Number;
import edu.austral.ingsis.math.Variable;
import edu.austral.ingsis.math.operations.*;
import java.util.ArrayList;
import java.util.List;

public class ListingVisitor implements Visitor<List<String>> {

  private final List<String> variables = new ArrayList<>();

  @Override
  public List<String> visit(Addition addition) {
    addition.getLeft().accept(this);
    addition.getRight().accept(this);
    return variables;
  }

  @Override
  public List<String> visit(Subtraction subtraction) {
    subtraction.getLeft().accept(this);
    subtraction.getRight().accept(this);
    return variables;
  }

  @Override
  public List<String> visit(Multiplication multiplication) {
    multiplication.getLeft().accept(this);
    multiplication.getRight().accept(this);
    return variables;
  }

  @Override
  public List<String> visit(Division division) {
    division.getDividend().accept(this);
    division.getDivisor().accept(this);
    return variables;
  }

  @Override
  public List<String> visit(Power power) {
    power.getBase().accept(this);
    power.getExponent().accept(this);
    return variables;
  }

  @Override
  public List<String> visit(SquareRoot squareRoot) {
    squareRoot.getFunction().accept(this);
    return variables;
  }

  @Override
  public List<String> visit(AbsoluteValue absoluteValue) {
    absoluteValue.getFunction().accept(this);
    return variables;
  }

  @Override
  public List<String> visit(Number number) {
    return variables;
  }

  @Override
  public List<String> visit(Variable variable) {
    variables.add(variable.getName());
    return variables;
  }
}
