package org.example.controller;

import org.assertj.core.api.Assertions;
import org.example.model.Digit;
import org.example.model.Node;
import org.example.model.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EvaluatorTest {

    Evaluator evaluator;

    @BeforeEach
    void setUp() {
        evaluator = new Evaluator();
    }

    @Test
    void evaluateOnlyDigitReturnItsValue() {
        // GIVEN
        Node inputTreeNode = new Digit("7");
        int expectedResult = 7;

        // WHEN
        int result = evaluator.evaluate(inputTreeNode);

        // THEN
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void evaluateAdditionTreeReturnAddedIntegers() {
        // GIVEN
        Node inputTreeNode = new Operator(Operator.OperatorType.ADDITION,
                new Digit(1),
                new Digit(2));
        int expectedResult = 3;

        // WHEN
        int result = evaluator.evaluate(inputTreeNode);

        // THEN
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void evaluateMultiplicationTreeReturnMultipliedIntegers() {
        // GIVEN
        Node inputTreeNode = new Operator(Operator.OperatorType.MULTIPLICATION,
                new Digit(1),
                new Digit(2));
        int expectedResult = 2;

        // WHEN
        int result = evaluator.evaluate(inputTreeNode);

        // THEN
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void evaluateDivisionTreeReturnDividedIntegers() {
        // GIVEN
        Node inputTreeNode = new Operator(Operator.OperatorType.DIVISION,
                new Digit(4),
                new Digit(2));
        int expectedResult = 2;

        // WHEN
        int result = evaluator.evaluate(inputTreeNode);

        // THEN
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void evaluateSubtractionTreeReturnSubtractedIntegers() {
        // GIVEN
        Node inputTreeNode = new Operator(Operator.OperatorType.SUBTRACTION,
                new Digit(3),
                new Digit(2));
        int expectedResult = 1;

        // WHEN
        int result = evaluator.evaluate(inputTreeNode);

        // THEN
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void evaluateAdditionAndSubtractionTreeReturnResult() {
        // GIVEN
        Node inputTreeNode = new Operator(Operator.OperatorType.ADDITION,
                new Operator(Operator.OperatorType.SUBTRACTION,
                        new Digit(3),
                        new Digit(2)),
                new Digit(1));
        int expectedResult = 2;

        // WHEN
        int result = evaluator.evaluate(inputTreeNode);

        // THEN
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }
}