package org.leetcode.BinaryTreeDFS;

public class PathSumThree {

  static int answer = 0;
  /*
  Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

  The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

  Example 1:
  Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
  Output: 3
  Explanation: The paths that sum to 8 are shown.

  Example 2:
  Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
  Output: 3
  * */

  public static void main(String[] args) {
    Integer [] nums = {10,5,-3,3,2,null,11,3,-2,null,1};
    Integer [] nums1 = {5,4,8,11,null,13,4,7,2,null,null,5,1};
    TreeNode treeNode = TreeNode.buildTree(nums, 0);
    TreeNode treeNode1 = TreeNode.buildTree(nums1, 0);
    System.out.println(pathSum(treeNode , 8));
    System.out.println(pathSum(treeNode1 , 22));
  }

  public static int pathSum(TreeNode root, int targetSum) {
    pathSumCounter(root, targetSum, 0);
    return answer;
  }

  public static void pathSumCounter(TreeNode root, int targetSum, int count) {

    if(root == null) return;

    if (root.val + count == targetSum) answer++;

    if (root.val + count >= targetSum) {
      pathSumCounter(root.left, targetSum, 0);
    } else {
      pathSumCounter(root.left, targetSum, root.val + count);
    }

    if (root.val + count >= targetSum) {
      pathSumCounter(root.right, targetSum, 0);
    } else {
      pathSumCounter(root.right, targetSum, root.val + count);
    }

  }
}
