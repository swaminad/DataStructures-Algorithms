class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftWall = new int[n];
        int[] rightWall = new int[n];
        int max_so_far = -1;
        
        //Calculating the left wall for all position OR prev max
        for(int i =0;i<n;i++){
            max_so_far = max(height[i],max_so_far);
            leftWall[i] = max_so_far;        
        }
        
        max_so_far = -1;
        //Calculating the right wall for all position OR suff max
        for(int i =n-1;i>=0;i--){
            max_so_far = max(height[i],max_so_far);
            rightWall[i] = max_so_far;
        }
        
        int sum = 0;
        //Take the min of leftWall and rightWall and subtract current height -> water that can be hold in current poisition 
        for(int i =0;i<n;i++){
            sum = sum + (min(leftWall[i],rightWall[i]) - height[i]);
        }
        
        return sum;
    }
    
    public int max(int a,int b){
        if(a>b) return a;
        return b;
    }
    
    public int min(int a,int b){
        if(a<b) return a;
        return b;
    }
}