class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        for(int i = 0; i < nums.length ; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(target == nums[i] + nums[j]){
                    return new int[] { i, j};
                }
            }
        }*/
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i < nums.length; i++){
            if(map.containsKey(target - nums [i]))
                return new int[] { i, map.get(target - nums [i])};
            else
                map.put(nums[i],i);
        }
        for(int i = 0;i < nums.length; i++){
            
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}