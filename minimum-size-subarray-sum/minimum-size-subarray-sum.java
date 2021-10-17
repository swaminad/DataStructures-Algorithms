class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        //Sliding window
        int low =0,high = 0, min= Integer.MAX_VALUE;
        int sum = 0;
        
        //WHile the high is less than nums.length
        while(high < nums.length){
            sum = sum + nums[high];
            
            if(sum>=target){
                
                while(low<=high && sum >= target){
                    min = Math.min(min,high-low+1);
                    sum = sum -nums[low];
                    low++;
                }
            }
            
            high++;
            
        }
        
        if(min == Integer.MAX_VALUE)
            return 0;
        
        return min;
        
        /*int n = nums.length;
        int[] preSum = new int[n+1];
        preSum[0] = 0;
        
        //Edge case if the sum of all elements itself not giving the target
        int sum = 0;
        for(int i =0;i<nums.length;i++){
            sum = sum + nums[i];
            preSum[i+1] = sum;
        }
        if(sum < target) return 0;
        
        
        //Sysout the preSum
        for(int i :preSum){
            System.out.println("The Presum is "+i);            
        }
        
        //Find the answer range which will be 1 to n
        int l = 1, r = n;
        while(l<r){
            int mid = l + ((r-l)/2);
            if(canMidSatisfy(preSum,mid,target)){
                r = mid;
            }else{
                l = mid+1;
            }
            
        }
        
        return l;*/
        
    }
    
    public boolean canMidSatisfy(int[] preSum,int mid,int target){
        
        //Loop through the preSum from mid to n if a[i] - a[i-mid] is equal to target return true
        for(int i = mid;i<preSum.length;i++){
            System.out.println("mid::target "+mid+" "+target+" "+(preSum[i]-preSum[i-mid]));
            if(target == (preSum[i]-preSum[i-mid])) return true;
        }
        return false;
    }
}