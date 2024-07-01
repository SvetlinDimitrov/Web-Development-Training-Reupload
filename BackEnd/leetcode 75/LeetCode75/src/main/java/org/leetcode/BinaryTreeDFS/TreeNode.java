package org.leetcode.BinaryTreeDFS;

public class TreeNode {
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

  public static TreeNode buildTree(Integer[] nodes, int index) {
    if (index >= nodes.length || nodes[index] == null) {
      return null;
    }

    TreeNode node = new TreeNode(nodes[index]);
    node.left = buildTree(nodes, 2 * index + 1);
    node.right = buildTree(nodes, 2 * index + 2);

    return node;
  }
}