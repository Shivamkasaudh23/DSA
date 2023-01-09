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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        solve(ans,op,root,targetSum);
        return ans;
    }
    void solve(List<List<Integer>> ans, List<Integer> op,TreeNode root, int targetSum){
        
        if(root == null)
            return;
    
        op.add(root.val);
        
        if(root.left == null && root.right==null && root.val == targetSum){
            ans.add(new ArrayList<>(op));
        }
        else{
            solve(ans,op,root.left,targetSum-root.val);
            solve(ans,op,root.right,targetSum-root.val);
        }
        op.remove(op.size()-1);
    }
}