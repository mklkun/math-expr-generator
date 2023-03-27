package org.example.model;

import java.util.Objects;

public class Operator implements Node {

    public enum OperatorType {
        MULTIPLICATION,
        DIVISION,
        ADDITION,
        SUBTRACTION
    }

    private final OperatorType type;
    private final Node left;
    private final Node right;

    public Operator(OperatorType type, Node left, Node right) {
        this.type = type;
        this.left = left;
        this.right = right;
    }

    public Operator(String operatorStr, Node left, Node right) {
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
        }
        this.left = left;
        this.right = right;
    }

    public OperatorType getType() {
        return type;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
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

    public int eval() {
        switch (type) {
            case MULTIPLICATION:
                return this.left.eval() * this.right.eval();
            case DIVISION:
                return this.left.eval() / this.right.eval();
            case ADDITION:
                return this.left.eval() + this.right.eval();
            default:
                return this.left.eval() - this.right.eval();
        }
    }
 }
