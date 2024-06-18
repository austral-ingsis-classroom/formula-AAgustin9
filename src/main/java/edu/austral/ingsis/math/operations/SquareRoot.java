package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.Visitor;

public class SquareRoot implements Function {

    private final Function function;

    public SquareRoot(Function function) {
        this.function = function;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    public Function getFunction() {
        return function;
    }

}
