package org.example.controller;

import org.assertj.core.api.Assertions;
import org.example.model.Digit;
import org.example.model.Operator;
import org.example.model.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluatorTest {

    Evaluator evaluator;

    @BeforeEach
    void setUp() {
        evaluator = new Evaluator();
    }

    @Test
    void evaluateOnlyDigitReturnItsValue() {
        // GIVEN
        TreeNode inputTreeNode = new TreeNode(new Digit("7"));
        int expectedResult = 7;

        // WHEN
        int result = evaluator.evaluate(inputTreeNode);

        // THEN
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void evaluateAdditionTreeReturnAddedIntegers() {
        // GIVEN
        TreeNode inputTreeNode = new TreeNode(new Operator(Operator.OperatorType.ADDITION),
                new TreeNode(new Digit(1)),
                new TreeNode(new Digit(2)));
        int expectedResult = 3;

        // WHEN
        int result = evaluator.evaluate(inputTreeNode);

        // THEN
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void evaluateMultiplicationTreeReturnMultipliedIntegers() {
        // GIVEN
        TreeNode inputTreeNode = new TreeNode(new Operator(Operator.OperatorType.MULTIPLICATION),
                new TreeNode(new Digit(1)),
                new TreeNode(new Digit(2)));
        int expectedResult = 2;

        // WHEN
        int result = evaluator.evaluate(inputTreeNode);

        // THEN
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void evaluateDivisionTreeReturnDividedIntegers() {
        // GIVEN
        TreeNode inputTreeNode = new TreeNode(new Operator(Operator.OperatorType.DIVISION),
                new TreeNode(new Digit(4)),
                new TreeNode(new Digit(2)));
        int expectedResult = 2;

        // WHEN
        int result = evaluator.evaluate(inputTreeNode);

        // THEN
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void evaluateSubtractionTreeReturnSubtractedIntegers() {
        // GIVEN
        TreeNode inputTreeNode = new TreeNode(new Operator(Operator.OperatorType.SUBTRACTION),
                new TreeNode(new Digit(3)),
                new TreeNode(new Digit(2)));
        int expectedResult = 1;

        // WHEN
        int result = evaluator.evaluate(inputTreeNode);

        // THEN
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void evaluateAdditionAndSubtractionTreeReturnResult() {
        // GIVEN
        TreeNode inputTreeNode = new TreeNode(new Operator(Operator.OperatorType.ADDITION),
                new TreeNode(new Operator(Operator.OperatorType.SUBTRACTION),
                        new TreeNode(new Digit(3)),
                        new TreeNode(new Digit(2))),
                new TreeNode(new Digit(1)));
        int expectedResult = 2;

        // WHEN
        int result = evaluator.evaluate(inputTreeNode);

        // THEN
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }
}