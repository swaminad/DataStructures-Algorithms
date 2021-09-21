class Solution {
    
    //Recursion method
    public boolean backtrack(int bi,int bj,char[][] board,int index,String word){
        //base Condition
        if(index == word.length()) return true;
        
        if(bi < 0 || bj < 0 || bi == board.length || bj == board[0].length) return false;
        
        //board within boundary and word is there to search
        if(board[bi][bj] == word.charAt(index)){
            //Make the current position as visited for this path. Don't worry we will restore once the current path is done
            char temp = board[bi][bj];
            board[bi][bj] = '-';
            boolean b = backtrack(bi+1,bj,board,index+1,word) || backtrack(bi-1,bj,board,index+1,word) || backtrack(bi,bj+1,board,index+1,word) || backtrack(bi,bj-1,board,index+1,word);
            board[bi][bj] = temp;
            return b;
        }else return false;
        
    }
    public boolean exist(char[][] board, String word) {
        //DFS method
        //First go through the board and find if the first character is available
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(backtrack(i,j,board,0,word)) return true;
                }
            }
        }
        return false;
        /**Important:: I am going solve in DFS also please check the leetcode if you see this in github**/
        /*
        //Create the Queue
        Queue<int[]> queue = new LinkedList<>();
        //HashMap to store the path
        HashMap<int[],Set<int[]>> pathNodes = new HashMap<>();
        
        //Add the first level
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    int[] p=new int[]{i,j};
                    queue.add(p);
                    Set<int[]> path = new HashSet<>();
                    path.add(p);
                    pathNodes.put(p,path);                    
                }
            }
        }
        
        //if first character itself not available
        if(queue.isEmpty()) return false;
        
        int index = 1; int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        //loop through the each level
        while(!queue.isEmpty()){
            //if we already got the word
            if(index == word.length()){
                return true;    
            }
            
            //Current level size
            int size = queue.size();
            
            //Loop through the current level
            for(int i =0;i<size;i++){
                int[] currNode = queue.remove();
                
                //Get all its neighbours
                for(int[] dir:dirs){
                    int ni = currNode[0] + dir[0];
                    int nj = currNode[1] + dir[1];
                   
                    
                    //Check the neighbour is index character
                    if(ni >=0 && ni < board.length && nj >= 0 && nj < board[0].length && board[ni][nj] == word.charAt(index)){                        
                        //Check the neighbour node is already in path
                        Set<int[]> path = pathNodes.get(currNode);
                        //flag to check
                        boolean flag = false;
                        
                       // System.out.println("Current Node is "+currNode[0]+" "+currNode[1]+" neighbour node is "+ni+" "+nj+" Current character is "+word.charAt(index));
                        for(int[] k:path){
                            //System.out.println(k[0] + " "+k[1]);
                            if(ni == k[0] && nj == k[1]){
                                flag = true;
                            }
                        }
                        
                        if(!flag){
                            int[] p = new int[]{ni,nj};
                            queue.add(p);
                            Set<int[]> neighPath = new HashSet<>();
                            neighPath.addAll(path);
                            neighPath.add(p);                            
                            pathNodes.put(p,neighPath);    
                        }                     
                        
                    }
                }
            }
            index = index +1;
        }
        
        return false;*/
    }
}