package org.example.controller;

import org.assertj.core.api.Assertions;
import org.example.model.Digit;
import org.example.model.Operator;
import org.example.model.TreeNode;
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
        TreeNode resultTreeNode = generator.generate(inputExpression);

        // THEN
        TreeNode expectedTreeNode = new TreeNode(new Digit("7"));
        Assertions.assertThat(resultTreeNode).isEqualTo(expectedTreeNode);
    }

    @Test
    void generateOneOperatorExprShouldReturnTreeNodeHeight2() {
        // GIVEN
        String inputExpression = "[+,1,2]";
        TreeNode expectedTreeNode = new TreeNode(new Operator(Operator.OperatorType.ADDITION),
                new TreeNode(new Digit(1)),
                new TreeNode(new Digit(2)));

        // WHEN
        TreeNode resultTreeNode = generator.generate(inputExpression);

        // THEN
        Assertions.assertThat(resultTreeNode).isEqualTo(expectedTreeNode);
    }

    @Test
    void generateTwoOperatorsLeftExprShouldReturnTreeNodeHeight3() {
        // GIVEN
        String inputExpression = "[+,[-,3,2],1]";
        TreeNode expectedTreeNode = new TreeNode(new Operator(Operator.OperatorType.ADDITION),
                new TreeNode(new Operator(Operator.OperatorType.SUBTRACTION),
                        new TreeNode(new Digit(3)),
                        new TreeNode(new Digit(2))),
                new TreeNode(new Digit(1)));

        // WHEN
        TreeNode resultTreeNode = generator.generate(inputExpression);

        // THEN
        Assertions.assertThat(resultTreeNode).isEqualTo(expectedTreeNode);
    }

    @Test
    void generateTwoOperatorsRightExprShouldReturnTreeNodeHeight3() {
        // GIVEN
        String inputExpression = "[+,1,[-,3,2]]";
        TreeNode expectedTreeNode = new TreeNode(new Operator(Operator.OperatorType.ADDITION),
                new TreeNode(new Digit(1)),
                new TreeNode(new Operator(Operator.OperatorType.SUBTRACTION),
                        new TreeNode(new Digit(3)),
                        new TreeNode(new Digit(2))));

        // WHEN
        TreeNode resultTreeNode = generator.generate(inputExpression);

        // THEN
        Assertions.assertThat(resultTreeNode).isEqualTo(expectedTreeNode);
    }
}