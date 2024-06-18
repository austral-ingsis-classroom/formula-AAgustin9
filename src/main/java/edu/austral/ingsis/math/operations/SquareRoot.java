package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.Visitor;

public class SquareRoot implements Function {

    private final Function value;

    public SquareRoot(Function value) {
        this.value = value;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return null;
    }

}
