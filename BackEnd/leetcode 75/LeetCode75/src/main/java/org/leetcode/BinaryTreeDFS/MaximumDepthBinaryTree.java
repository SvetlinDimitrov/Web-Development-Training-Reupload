package org.leetcode.BinaryTreeDFS;

public class MaximumDepthBinaryTree {

  /*
  Given the root of a binary tree, return its maximum depth.

  A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

  Example 1:
  Input: root = [3,9,20,null,null,15,7]
  Output: 3

  Example 2:
  Input: root = [1,null,2]
  Output: 2
  * */
  public static void main(String[] args) {
    TreeNode example = new TreeNode(3,
        new TreeNode(9),
        new TreeNode(20,
            new TreeNode(15),
            new TreeNode(7)));

    System.out.println(maxDepth(example));
  }

  public static int maxDepth(TreeNode root) {
    return maxDepth(root, 0);
  }

  private static int maxDepth(TreeNode root, int depth) {
    if(root == null) return depth;
    int left = maxDepth(root.left, depth + 1);
    int right = maxDepth(root.right, depth + 1);
    return Math.max(left, right);
  }
}
