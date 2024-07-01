package org.leetcode.BinaryTreeDFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeafSimilarTrees {

  /*
  Consider all the leaves of a binary tree, from left to right order, the values of those leaves
  form a leaf value sequence.

  For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

  Two binary trees are considered leaf-similar if their leaf value sequence is the same.

  Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

  Example 1:
  Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
  Output: true

  Example 2:
  Input: root1 = [1,2,3], root2 = [1,3,2]
  Output: false
  * */

  public static void main(String[] args) {
    Integer[] nums1 = {3, 5, 1, 6, 2, 9, 8, null, null, 7, 4};
    Integer[] nums2 = {3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8};
    TreeNode treeNode = TreeNode.buildTree(nums1, 0);
    TreeNode treeNode1 = TreeNode.buildTree(nums2, 0);

    System.out.println(leafSimilar(treeNode1, treeNode));

  }

  public static boolean leafSimilar(TreeNode root1, TreeNode root2) {

    var root1Leafs = new ArrayDeque<Integer>();
    var root2Leafs = new ArrayDeque<Integer>();

    dfsLeafsFinder(root1 , root1Leafs);
    dfsLeafsFinder(root2 , root2Leafs);

    if(root1Leafs.size() != root2Leafs.size()) return false;

    while(!root1Leafs.isEmpty()){
      if(!root1Leafs.poll().equals(root2Leafs.poll())) return false;
    }

    return true;
  }

  public static void dfsLeafsFinder(TreeNode root , Queue<Integer> queue) {

    if(root == null) return;

    dfsLeafsFinder(root.left , queue);
    dfsLeafsFinder(root.right , queue);

    if(root.left == null && root.right == null) queue.offer(root.val);
  }
}
