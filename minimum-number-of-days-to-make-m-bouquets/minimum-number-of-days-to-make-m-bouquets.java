class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        //edge case
        int n = bloomDay.length;
        if(n < k*m) return -1;
        if(m == 0) return -1;
        
        //Find the answer range
        int left = Integer.MAX_VALUE,right=Integer.MIN_VALUE;
        
        for(int i:bloomDay){
            if(i<left) left = i;
            if(i>right) right = i;
        }
        
        //Do the Binary Search in answer range
        while(left<right){
            int mid = left + ((right-left)/2);
            
            if(canMidSatisfy(bloomDay,mid,k) >= m){
                right = mid;
            }else{
                left = mid+1;
            }
            
        }
        return left;
    }
    
    
    public int canMidSatisfy(int[] nums,int mid,int k){
        
        int streak =0,res =0;
        for(int i=0;i<nums.length;i++){
            //nums[i] is lesser than mid then we can increase the streak
            if(nums[i]<=mid){
                streak++;
            }else{
                streak = 0;
            }
            if(streak >= k){                
                streak =0;
                res++;
            }
            
        }
        return res;
    }
}