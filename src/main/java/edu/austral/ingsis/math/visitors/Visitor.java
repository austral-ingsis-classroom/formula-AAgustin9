package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.Number;
import edu.austral.ingsis.math.Variable;
import edu.austral.ingsis.math.operations.*;

public interface Visitor<T> {

  T visit(Addition addition);

  T visit(Subtraction subtraction);

  T visit(Multiplication multiplication);

  T visit(Division division);

  T visit(Power power);

  T visit(SquareRoot squareRoot);

  T visit(AbsoluteValue absoluteValue);

  T visit(Number number);

  T visit(Variable variable);
}
