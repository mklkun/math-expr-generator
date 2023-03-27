package org.example.controller;

import org.example.model.Digit;
import org.example.model.Operator;
import org.example.model.TreeNode;

public class Evaluator {

    public int evaluate(TreeNode treeNode) {
        if (treeNode.getOperand() instanceof Digit)
            return ((Digit) treeNode.getOperand()).getValue();
        return ((Operator) treeNode.getOperand()).eval(
                    evaluate(treeNode.getLeft()),
                    evaluate(treeNode.getRight()));
    }
}
