package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.Number;
import edu.austral.ingsis.math.Variable;
import edu.austral.ingsis.math.operations.*;

import java.util.Map;

public class SolveVisitor implements Visitor<Double> {

    private final Map<String, Number> variables;

    public SolveVisitor(Map<String, Number> variables) {
        this.variables = variables;
    }

    @Override
    public Double visit(Addition addition) {
        return addition.getLeft().accept(this) + addition.getRight().accept(this);
    }

    @Override
    public Double visit(Subtraction subtraction) {
        return subtraction.getLeft().accept(this) - subtraction.getRight().accept(this);
    }

    @Override
    public Double visit(Multiplication multiplication) {
        return multiplication.getLeft().accept(this) * multiplication.getRight().accept(this);
    }

    @Override
    public Double visit(Division division) {
        return division.getDividend().accept(this) / division.getDivisor().accept(this);
    }

    @Override
    public Double visit(Power power) {
        return Math.pow(power.getBase().accept(this), power.getExponent().accept(this));
    }

    @Override
    public Double visit(SquareRoot squareRoot) {
        return Math.sqrt(squareRoot.getFunction().accept(this));
    }

    @Override
    public Double visit(AbsoluteValue absoluteValue) {
        return Math.abs(absoluteValue.getFunction().accept(this));
    }

    @Override
    public Double visit(Number number) {
        return number.getValue();
    }

    @Override
    public Double visit(Variable variable) {
        if (variables.containsKey(variable.getName())) {
            return variables.get(variable.getName()).getValue();
        } else {
            throw new IllegalArgumentException("Variable " + variable.getName() + " not found");
        }
    }
}
