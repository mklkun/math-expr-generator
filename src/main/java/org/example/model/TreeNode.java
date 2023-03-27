package org.example.model;

import java.util.Objects;

public class TreeNode {

    public Operand getOperand() {
        return operand;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    Operand operand;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    public TreeNode(Operand operand) {
        this.operand = operand;
    }

    public TreeNode(Operand operand, TreeNode left, TreeNode right) {
        this.operand = operand;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return Objects.equals(operand, treeNode.operand) && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand, left, right);
    }
}
