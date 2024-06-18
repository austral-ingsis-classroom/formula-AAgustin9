package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.Number;
import edu.austral.ingsis.math.Variable;
import edu.austral.ingsis.math.operations.*;

import java.util.List;

public class ListingVisitor implements Visitor<List<String>> {



    @Override
    public List<String> visit(Addition addition) {
        return null;
    }

    @Override
    public List<String> visit(Subtraction subtraction) {
        return null;
    }

    @Override
    public List<String> visit(Multiplication multiplication) {
        return null;
    }

    @Override
    public List<String> visit(Division division) {
        return null;
    }

    @Override
    public List<String> visit(Power power) {
        return null;
    }

    @Override
    public List<String> visit(SquareRoot squareRoot) {
        return null;
    }

    @Override
    public List<String> visit(AbsoluteValue absoluteValue) {
        return null;
    }

    @Override
    public List<String> visit(Number number) {
        return null;
    }

    @Override
    public List<String> visit(Variable variable) {
        return null;
    }
}
