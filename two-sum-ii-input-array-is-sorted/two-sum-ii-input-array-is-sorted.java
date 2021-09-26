class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //Assign two pointers
        int i =0,j=numbers.length-1;
        
        //forward the i and backward the j until i<j
        while(i<j){
            int temp = numbers[i] + numbers[j];
            
            if(target == temp){
                return new int[]{i+1,j+1};
            }else if(temp > target){
                j--;
            }else{
                i++;
            }
        }
        return null;
    }
}