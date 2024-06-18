package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitors.Visitor;

public interface Function {

    public <T> T accept(Visitor<T> visitor);
}
