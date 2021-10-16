class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        
        int n = piles.length;
        //Find the answer range
        int max = 0;
        for(int i :piles){
            if(max<i) max =i;           
        }
        
        int l = 1,r = max;
        
        //Do the Binary Search
        while(l<r){
            
            int mid = l + ((r-l)/2);
            if(canMidSatisfy(piles,mid,h)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        
        return l;
    }
    
    public boolean canMidSatisfy(int[] piles,int mid,int h){
        int actualHours = 0;
        
        //Loop through the array and find the actualHours for each pile
        for(int i = 0;i<piles.length;i++){
            actualHours = actualHours + (piles[i] / mid);
            if(piles[i]%mid > 0) actualHours++;
        }
        
        if(actualHours<=h) return true;
        
        return false;
        
    }
}