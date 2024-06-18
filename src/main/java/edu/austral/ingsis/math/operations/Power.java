package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.Visitor;

public class Power implements Function {

    private final Function base;
    private final Function exponent;

    public Power(Function base, Function exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    public Function getBase() {
        return base;
    }
    public Function getExponent() {
        return exponent;
    }
}
