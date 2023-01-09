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
    int max_level = 0;
     public List<Integer> rightSideView(TreeNode root) {
         List<Integer> arr = new ArrayList<>();
         solve(arr,root,1);
         return arr;
     }
     void solve(List<Integer> arr, TreeNode root, int level){
         if(root == null){
             return ;
         }
         if(max_level<level){
             arr.add(root.val);
             max_level = level;
         }
         solve(arr,root.right,level+1);
         solve(arr,root.left,level+1);
     }   
 }