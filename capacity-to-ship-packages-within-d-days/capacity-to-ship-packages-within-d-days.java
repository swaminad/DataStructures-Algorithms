class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //Here we have "days" days within that we need to ship all weights. Here we need Mininum weight capacity of ship which ship all weights within "days"
        //Hence it is continues so no sorting.
        //here answer range will be Max weight <=> sum of all weight
        
        int n = weights.length;
        
        //Find the answer range max and sum of all weight
        int sum = 0, max = Integer.MIN_VALUE;
        for(int i : weights){
            if(i>max) max = i;
            sum = sum + i;            
        }
        int l =max,r=sum;
        
        //Do the BFS
        while(l<r){
            
            int mid = l + ((r-l)/2);
            System.out.println("left:: right:: mid :: "+l +" "+r+" "+mid);
            if(canMidSatisfy(weights,days,mid)) {
                r = mid;
            }else{
                l = mid +1;
            }
            
        }
        
        return l;
    }
    
    public boolean canMidSatisfy(int[] nums,int days,int mid){
        int sum =0,res =0;
        
        //loop through the array and find how parts will come if we break with mid as sum
        for(int i =0;i<nums.length;i++){
            sum  = sum + nums[i];
            if(sum > mid){
                sum = nums[i];
                res++;
            }
        }
        res++;
        //if the parts are equal to days then return true
        if(res <= days){
            return true;            
        }
        
        return false;
        
    }
}