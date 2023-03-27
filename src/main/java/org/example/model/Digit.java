package org.example.model;

import java.util.Objects;

public class Digit implements Node {

    private final int value;

    public Digit(int value) {
        this.value = value;
    }

    public Digit(String s) throws NumberFormatException {
        this.value = Integer.parseInt(s);
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Digit digit = (Digit) o;
        return Objects.equals(value, digit.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int eval() {
        return this.value;
    }
}
