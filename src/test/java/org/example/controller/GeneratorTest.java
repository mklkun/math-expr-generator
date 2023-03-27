package org.example.controller;

import org.assertj.core.api.Assertions;
import org.example.model.Digit;
import org.example.model.Node;
import org.example.model.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class GeneratorTest {

    Generator generator;

    @BeforeEach
    void setUp() {
        generator = new Generator();
    }

    @Test
    void generateOnlyDigitShouldReturnTreeOneNode() {
        // GIVEN
        String inputExpression = "7";

        // WHEN
        Node resultTreeNode = generator.generate(inputExpression);

        // THEN
        Node expectedTreeNode = new Digit("7");
        Assertions.assertThat(resultTreeNode).isEqualTo(expectedTreeNode);
    }

    @Test
    void generateOneOperatorExprShouldReturnTreeNodeHeight2() {
        // GIVEN
        String inputExpression = "[+,1,2]";
        Node expectedTreeNode = new Operator(Operator.OperatorType.ADDITION,
                new Digit(1),
                new Digit(2));

        // WHEN
        Node resultTreeNode = generator.generate(inputExpression);

        // THEN
        Assertions.assertThat(resultTreeNode).isEqualTo(expectedTreeNode);
    }

    @Test
    void generateTwoOperatorsLeftExprShouldReturnTreeNodeHeight3() {
        // GIVEN
        String inputExpression = "[+,[-,3,2],1]";
        Node expectedTreeNode = new Operator(Operator.OperatorType.ADDITION,
                new Operator(Operator.OperatorType.SUBTRACTION,
                        new Digit(3),
                        new Digit(2)),
                new Digit(1));

        // WHEN
        Node resultTreeNode = generator.generate(inputExpression);

        // THEN
        Assertions.assertThat(resultTreeNode).isEqualTo(expectedTreeNode);
    }

    @Test
    void generateTwoOperatorsRightExprShouldReturnTreeNodeHeight3() {
        // GIVEN
        String inputExpression = "[+,1,[-,3,2]]";
        Node expectedTreeNode = new Operator(Operator.OperatorType.ADDITION,
                new Digit(1),
                new Operator(Operator.OperatorType.SUBTRACTION,
                        new Digit(3),
                        new Digit(2)));

        // WHEN
        Node resultTreeNode = generator.generate(inputExpression);

        // THEN
        Assertions.assertThat(resultTreeNode).isEqualTo(expectedTreeNode);
    }
}