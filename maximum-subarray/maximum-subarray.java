class Solution {
    public int maxSubArray(int[] nums) {
        //Dynamic Programming
        int n = nums.length;
        int[] dp = new int[n];
        int max_so_far = nums[0]; dp[0] = nums[0];
        for(int i = 1;i<n;i++){
            dp[i] = max(nums[i],nums[i]+dp[i-1]);
            max_so_far = max(max_so_far,dp[i]);
        }
        return max_so_far;
        /*//Kandane's algorithm
        int n = nums.length;
        int max_ending_here = 0,max_so_far = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max_ending_here = max_ending_here + nums[i];
            //System.out.println("max_ending_here is "+max_ending_here+" i "+i);
            if(max_ending_here > max_so_far)
                max_so_far = max_ending_here;
            if(max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;*/
        /*//Brute force solution
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum =0;
            for(int j=i;j<n;j++){
                sum = sum + nums[j];
                maxSum = max(maxSum,sum);
            }
        }
        
        return maxSum;*/
    }
    public int max(int a,int b){
        if(a>b) return a;
        return b;
    }
}