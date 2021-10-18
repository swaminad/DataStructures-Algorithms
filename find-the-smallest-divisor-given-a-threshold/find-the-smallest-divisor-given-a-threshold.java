class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        
        //Find the answer range - divisor will be from 1 to max element in array
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            if(max<i) max = i;
        }
        
        int l = 1,r = max;
        
        //Do the Binary Search
        while(l<r){
           
            int mid = l + ((r-l)/2);
             //System.out.println("Left and right mid and threshold is "+l + " "+r+ " "+ mid+ " "+ threshold);
            if(canMidSatisfy(nums,mid,threshold)){
                r = mid;
            }else{
                l = mid+1;
            }
            
        }
        
        return l;
    }
    
    public boolean canMidSatisfy(int[] nums,int mid,int threshold){
        
       
        int sum = 0;
        //Loop through the array do the calculate the sum of the division's result
        for(int i = 0;i<nums.length;i++){
            sum = sum + (nums[i]/mid);
            if(nums[i]%mid != 0) sum++;
            // System.out.println("The sum is "+ sum);
        }
        
        if(sum <= threshold) return true;
        
        return false;
    }
}