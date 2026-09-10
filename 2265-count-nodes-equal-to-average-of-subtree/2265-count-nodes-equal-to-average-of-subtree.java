/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        int val;
        int count;
        public Pair(int val, int count){
            this.val = val;
            this.count = count;
        }
    }
    int result = 0;
    public Pair solve(TreeNode root){
        if(root == null){
            return new Pair(0, 0);
        }
        Pair left = solve(root.left);
        Pair right = solve(root.right);
        int val = left.val + right.val + root.val;
        int count = left.count + right.count + 1;
        if(val/ count == root.val){
            result++;
        }

        return new Pair(val, count);
    }
    public int averageOfSubtree(TreeNode root) {
       solve(root);

       return result;
    }
}