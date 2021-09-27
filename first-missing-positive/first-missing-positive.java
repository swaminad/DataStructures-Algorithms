class Solution {
    public int firstMissingPositive(int[] nums) {
        //find the min
        int min = Integer.MAX_VALUE;
        for(int i =0;i<nums.length;i++){
            if(min>nums[i] && nums[i]>0){
                min = nums[i];
            }
        }
        
        if(min > 1) return 1;
        
        //find the max
        int max = Integer.MIN_VALUE;
        for(int i =0;i<nums.length;i++){
            if(max<nums[i]){
                max = nums[i];
            }
        }
        
        if(max < 1) return 1;
        
        
      
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i =0;i<nums.length;i++){
            if(nums[i]>0 && !set.contains(nums[i])){
             
                set.add(nums[i]);
            }
                
        }
        
      
        int actSum =0;
        for(int i=1;i<=max;i++){
            if(!set.contains(i)) return i;
           
        }
        
        return max + 1;
        
      
    }
}