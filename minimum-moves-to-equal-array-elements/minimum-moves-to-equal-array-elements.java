class Solution {
    public int minMoves(int[] nums) {
      //find the min
        int min = Integer.MAX_VALUE;
        for(int num:nums){
            if(min>num)
                min = num;
        }
        
        //instead of increasing the all n-1 to match max other way of thinking is decrease current element to match min.
        int count =0;
        for(int num:nums){
            count = count + (num - min);
        }
        
        return count;
        /* //Declare the count
        int count =0;
        int n = nums.length;
        
        //base condition
        if(n == 1) return 0;
        //Sort the nums in place
        Arrays.sort(nums);
        
        while(nums[0]!=nums[n-1]){
            int diff = nums[n-1] - nums[0];
            count = count + diff; 
            //for(int i = 0;i<n-1;i++)//add diff between max and min to all elements expect max to make min and max equal
                nums[n-1] = nums[n-1] - diff;
            Arrays.sort(nums);
        }
        return count;*/
    }
}