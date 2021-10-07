class Solution {
    public int numRescueBoats(int[] people, int limit) {
        //Sort the array
        Arrays.sort(people);
        
        //two pointers at start and end
        int start =0,end = people.length -1,output =0;
        while(start<end){
            if(people[start]+people[end] <= limit){
                output++;
                start++;
                end--;
            }else{
                output++;
                end--;
            }
        }
        
        if(start == end){
            return output+1;
        }
        
        return output;
    }
}