package org.leetcode.BinaryTreeDFS;

import com.sun.source.tree.Tree;

public class CountGoodNodesBinaryTree {
  /*
  Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

  Return the number of good nodes in the binary tree.

  Example 1:
  Input: root = [3,1,4,3,null,1,5]
  Output: 4
  Explanation: Nodes in blue are good.
  Root Node (3) is always a good node.
  Node 4 -> (3,4) is the maximum value in the path starting from the root.
  Node 5 -> (3,4,5) is the maximum value in the path
  Node 3 -> (3,1,3) is the maximum value in the path.

  Example 2:
  Input: root = [3,3,null,4,2]
  Output: 3
  Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.

  Example 3:
  Input: root = [1]
  Output: 1
  Explanation: Root is considered as good.
  */

  public static void main(String[] args) {
    Integer [] nums = {3,1,4,3,null,1,5};
    Integer [] nums1 = {3,3,null,4,2};
    TreeNode treeNode = TreeNode.buildTree(nums, 0);
    TreeNode treeNode1 = TreeNode.buildTree(nums1, 0);
    System.out.println(goodNodes(treeNode));
    System.out.println(goodNodes(treeNode1));
  }

  public static int goodNodes(TreeNode root) {
    return goodNodesFinder(root) + 1;
  }

  public static int goodNodesFinder(TreeNode root ){
    if(root == null) return 0;

    int leftCount = goodNodesFinder(root.left);
    int rightCount = goodNodesFinder(root.right);

    if(root.left != null && root.val < root.left.val) leftCount++;
    if(root.right!= null && root.val < root.right.val) rightCount++;

    return leftCount + rightCount;

  }
}
