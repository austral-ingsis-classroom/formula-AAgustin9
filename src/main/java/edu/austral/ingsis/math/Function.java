package edu.austral.ingsis.math;

public interface Function {

    public <T> T accept(Visitor<T> visitor);
}
