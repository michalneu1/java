package org.example;

public enum Operation {
    ADD((a, b) -> a + b),
    MINUS((a, b) -> a - b),
    MULTIPLY((a, b) -> a * b),
    Division((a, b) -> b == 0 ? 0 : a / b);


    private final MathOperation operation;

    Operation(MathOperation op) {
        this.operation = op;
    }

    MathOperation getOperation() {
        return operation;
    }
}

@FunctionalInterface
interface MathOperation {
    double apply(double a, double b);
}