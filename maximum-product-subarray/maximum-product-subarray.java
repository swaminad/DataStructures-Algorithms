class Solution {
    public int maxProduct(int[] nums) {
       int max = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(max<nums[i]) 
                max = nums[i];
            int temp = nums[i];
                
            for(int j=i+1;j<n;j++){
                temp = temp * nums[j];
                if(temp > max)
                    max = temp;
            }
        }
        
        return max;/*
        //Kandanne's algorithm that means keep track of the positive segments only. if you encounter negative element then futher product will be negative only.
        int maxProSoFar =nums[0], maxProEndHere =nums[0];
        for(int i =1;i<nums.length;i++){
            maxProEndHere = maxProEndHere * nums[i];
            if(maxProEndHere > maxProSoFar)
                maxProSoFar = maxProEndHere;
            if(maxProEndHere < 0) // Since the current product is negative futher product also will be negative so better to make it 1;
                maxProEndHere = 1;
        }
        
        return maxProSoFar;*/
    }
}