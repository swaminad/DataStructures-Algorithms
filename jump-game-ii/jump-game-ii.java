class Solution {
    public int jump(int[] nums) {
        //declare the dp arrray
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;//no. of steps required to reach end index from start index if both are 0 then it is 0
        
        //fill the dp array
        for(int i = 0;i<nums.length;i++){
            int steps = nums[i];
            int step = 1; // it should be 1 becoz we need to update start from the next step from current position
            while(step<=steps && i+step < nums.length){                
                dp[i+step] = Math.min(dp[i+step],dp[i]+1);
                step++;
            }
        }
        
        return dp[nums.length - 1];
    }
}