class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //Consider this as graph but no need to create the graph. Do BFS from (0,0) using queue if you find any adjcent cell with 0 then change it into 1 and push it to queue
       //base condition
        if(grid.length == 1 && grid[0].length == 1){
           if(grid[0][0] == 1) return -1;
            return 1;
       }
           
        
        //Create a queue with int[]
        Queue<int[]> queue = new LinkedList<>();
        
        //add the top left to Queue which is the first level
        if(grid[0][0] == 0){
            queue.add(new int[]{0,0});    
        }
        
        //Declare the 8 direction
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,1},{1,-1},{-1,1}};
        //count variable
        int count = 0;
        
        //Do the BFS
        while(!queue.isEmpty()){
            //get the current level size
            int size = queue.size();
            count++;
            
            for(int i =0;i<size;i++){
                //get the value from queue
                int[] p = queue.poll();
                
                //Move to all 8 direction
                for(int j = 0;j<8;j++){
                    int ni = p[0] + dirs[j][0];
                    int nj = p[1] + dirs[j][1];                
                    
                    //ni and nj is new position so check if that position within boundary and not 0
                     if(ni >=0 && ni<grid.length && nj >=0 && nj < grid[0].length && grid[ni][nj]!=1){
                         if(ni == grid.length -1 && nj == grid[0].length -1)
                             return count+1;
                         queue.add(new int[]{ni,nj});
                         grid[ni][nj] = 1;
                     }    
                }
                
                
            }
        }
        
        return -1;
    }
}