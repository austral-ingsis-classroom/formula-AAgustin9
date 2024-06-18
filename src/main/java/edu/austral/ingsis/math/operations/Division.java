package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.Visitor;

public class Division implements Function {

    private final Function divisor;
    private final Function dividend;

    public Division(Function divisor, Function dividend) {
        this.divisor = divisor;
        this.dividend = dividend;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    public Function getDivisor() {
        return divisor;
    }
    public Function getDividend() {
        return dividend;
    }
}
