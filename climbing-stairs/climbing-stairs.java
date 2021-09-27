class Solution {
    public int climbStairs(int n) {
        //base Condition
        if(n == 1 ) return 1;
        if(n == 2) return 2;
        
        //declare the dp array
        int[] dp = new int[n];
        dp[0] =1;
        dp[1] =2;
        //assign 1 step and 2nd step possibility since our logic requires (n-1) & n-2
        for(int i = 2;i<n;i++){
            dp[i] = dp[i-1] + dp[i-2];//at each step possibility is either from previous step i-1 or prev->pre step i-2
        }
        
        return dp[n-1];
    }
}