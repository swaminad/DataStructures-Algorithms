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
    public List<TreeNode> allPossibleFBT(int n) {
       
        //BaseCondition
        if(n%2 == 0)
            return Collections.emptyList();
        
        //Bcoz current one node for root;
        --n;
        
        List<TreeNode> res = new ArrayList<>();
        //
        if(n == 0){
            TreeNode node  = new TreeNode(0);
            res.add(node);
            return res;
        }
            
        
        for(int i = 1;i<n;i=i+2){
            List<TreeNode> leftPossibities = allPossibleFBT(i);
            List<TreeNode> rightPossibities = allPossibleFBT(n-i);
            
            //Every leftPossibities should be combined with all rightPossibities
            for(TreeNode left:leftPossibities){
                for(TreeNode right:rightPossibities){
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        
        return res;
        
        
        /* //check if n is even then return null
        if(n % 2 == 0)
            return null;
        //call the recursion
        List<TreeNode> output = new ArrayList<>();
        TreeNode root = new TreeNode(0);
        recursion(root,root,n-1,output);
        
        return output;*/
    }
    
    //recursion method
    public void recursion(TreeNode curr,TreeNode root,int bal,List<TreeNode> output){
        //Base Condition
        if(bal == 2){
            curr.left = new TreeNode(0);
            curr.right = new TreeNode(0);
            output.add(root);
            return;
        }
        if(bal == 0){
            output.add(root);
            return;
        }
        
        //Copy the current tree into two and add the left and right to it. Here why i am creating two copies becoz we need seperate tree to hold different possibilities we can't add all in one tree.
        TreeNode leftRoot = new TreeNode(0);
        TreeNode leftCurr = copy(root,leftRoot,curr);
        
        TreeNode rightRoot = new TreeNode(0);
        TreeNode rightCurr = copy(root,rightRoot,curr);
        
        //Add two child to leftCurr and rightCurr
        leftCurr.left = new TreeNode(0);
        leftCurr.right = new TreeNode(0);
        
        rightCurr.left = new TreeNode(0);
        rightCurr.right = new TreeNode(0);
        
        //Added the children in both to get 2 possibilities. Now call the recursion
        recursion(leftCurr.left,leftRoot,bal-2,output);
        recursion(rightCurr.right,rightRoot,bal-2,output);
        
        
        
    }
    
    public TreeNode copy(TreeNode node,TreeNode copyNode,TreeNode curr){
        //BaseCondition
        if(node == null) return null;
        TreeNode leftCurr = null,rightCurr = null;
        if(node.left != null){
            copyNode.left = new TreeNode(0);
            copyNode.right = new TreeNode(0);
            leftCurr = copy(node.left,copyNode.left,curr);
            rightCurr = copy(node.right,copyNode.right,curr);
        }
        if(node == curr)
            return copyNode;
        if(leftCurr != null)
            return leftCurr;
        return rightCurr;
    }
}