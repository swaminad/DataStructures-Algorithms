class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        //Edge case
        if(n == 1) return 1;
        if(n == 0) return 0;
        //this dp will hold the max length of incresing subsequence upto that point
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int out = 0;
        
        for(int i =1;i<n;i++){
            //Each ith element has to be compared with 0 to i-1. if ith is greater then add dp[j] + 1. Now compare this dp[j] + i and dp[i] and set the max to dp[i]
            for(int j =0;j<i;j++){
                if(nums[i]>nums[j]){                    
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            out = Math.max(out,dp[i]);
        }      
        
        
        return out;
        
    }
}