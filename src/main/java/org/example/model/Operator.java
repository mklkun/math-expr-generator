package org.example.model;

import java.util.Objects;

public class Operator implements Operand {

    public enum OperatorType {
        MULTIPLICATION,
        DIVISION,
        ADDITION,
        SUBTRACTION
    }

    private final OperatorType type;

    public Operator(OperatorType type) {
        this.type = type;
    }

    public Operator(String operatorStr) {
        switch (operatorStr) {
            case "*":
                type = OperatorType.MULTIPLICATION;
                break;
            case "/":
                type = OperatorType.DIVISION;
                break;
            case "+":
                type = OperatorType.ADDITION;
                break;
            default:
                type = OperatorType.SUBTRACTION;
                break;
        };
    }

    public OperatorType getType() {
        return type;
    }

    public int eval(int left, int right) {
        switch (type) {
            case MULTIPLICATION:
                return left * right;
            case DIVISION:
                return left / right;
            case ADDITION:
                return left + right;
            default:
                return left - right;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator = (Operator) o;
        return type == operator.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
 }
