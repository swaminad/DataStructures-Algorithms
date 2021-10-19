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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //Create the queue and output list
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> output = new ArrayList<>();
        
        if(root == null) return output;
        
        //Add the element into the queue
        queue.add(root);
        boolean leftToRight = true;
        
        //Do the BFS
        while(!queue.isEmpty()){
            //Going level by level
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            
            for(int i =0;i<size;i++){
                //Getting the node from queue and adding it to list
                TreeNode temp = queue.remove();                 
                if(leftToRight){
                    list.add(temp.val);    
                }else{
                    stack.add(temp.val);
                }
                
                
               
                
                
                //Adding temp children into queue using leftToRight flag
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
                
            }
            
            
            //if  it is righttoleft then
            if(!leftToRight){
                while(!stack.empty()){
                    list.add(stack.pop());
                }
            }
            
            
            //Add list to output
            output.add(list);
            if(leftToRight){
                leftToRight = false;
            }else{
                leftToRight = true;
            }
        }
        
        return output;
    }
}