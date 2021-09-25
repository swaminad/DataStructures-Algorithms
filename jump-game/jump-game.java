class Solution {
    public boolean canJump(int[] nums) {
        //decalre the dp array
        int[] dp = new int[nums.length];
        
        //dp[0] is nums[0]
        dp[0] = nums[0];
        
        for(int i = 1; i<nums.length;i++){
            if(dp[i-1] == 0 && i-1 != nums.length-1)
                return false;
            dp[i] = Math.max(dp[i-1]-1,nums[i]); //dp[i]>0 repesents we can move from i else can't move from i 
            
        }
        
        return true;
    }
}