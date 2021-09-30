class Solution {
    public int subarraySum(int[] nums, int k) {
            //Hashmap to store the count of prefixsum
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum =0,count = 0;
        
        //Here concept is Sum(i,j) = Sum(0,j)-Sum(0,i) => here Sum(i,j) we want is k=> k = sum(0,j) - sum(0,i) =>sum(0,i) = sum(0,j) - k => so check if sum(0,j) - k is already available
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            if(map.containsKey(sum-k))
                count = count + map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        return count;
    }
}