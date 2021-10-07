class Solution {
    int res = Integer.MAX_VALUE;
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        //if n < m
        if(n<m)
            return -1;
        //Find the max and sum of the array
        int sum =0,max = 0;
        for(int i:nums){
            max = Math.max(i,max);
            sum = sum + i;
        }
        
        //if n = m then  the parts available is equal parts required so return max
        if(n == m)
            return max;
        
        //else answer  will be within the range of max and sum
        return bs(max,sum,nums,m);
        
    }
    
    public int bs(int left,int right,int[] nums,int m){
        
        //Base Condition
        if(left>right)
            return res;
        
        //Assume mid as answer
        int mid = ((right - left)/2)+left;
        
        //Divide the array into subarray which has max sum of mid
        int sum =0, parts =1;
        for(int i : nums){
            sum = sum +i;
            if(sum > mid){//if current subarray sum is greater than mid then sum = i and parts +1
                sum = i;
                parts++;
            }
        }
        if(parts > m){//if parts available is more than parts required then increase the sum so that more numbers will go to one part so that parts will be reduced
            left = mid+1;            
        }else{
            res = Math.min(res,mid);
            right = mid-1;
        }
        
        return bs(left,right,nums,m);
    }
}