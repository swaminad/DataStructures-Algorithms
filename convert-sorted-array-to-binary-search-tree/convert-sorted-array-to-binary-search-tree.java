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
    public TreeNode sortedArrayToBST(int[] nums) {
        return recursion(nums,0,nums.length-1);
    }
    
    public TreeNode recursion(int[] nums,int l,int r){
        //baseCondition
        if(l>r) return null;
        if(l == r) return new TreeNode(nums[l],null,null);
        
        //calc the middle element
        int m = l + (r-l)/2;
        
        TreeNode node = new TreeNode(nums[m]);
        node.left = recursion(nums,l,m-1);
        node.right = recursion(nums,m+1,r);
        
        return node;
    }
}