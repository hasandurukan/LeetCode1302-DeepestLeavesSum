package com.java101;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    List<Integer> sums = new ArrayList<>();

    int deepestLeavesSum(TreeNode root) {
        depthFirstSearch(root, 0);
        return sums.get(sums.size() - 1);
    }

    void depthFirstSearch(TreeNode node, int lvl) {
        if (lvl == sums.size()) sums.add(node.val);
        else sums.set(lvl, sums.get(lvl) + node.val);
        if (node.left != null) depthFirstSearch(node.left, lvl + 1);
        if (node.right != null) depthFirstSearch(node.right, lvl + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        //root.right.left.right.left = new TreeNode(9);
        Main program = new Main();
        int result = program.deepestLeavesSum(root);
        System.out.print(result);
    }
}
