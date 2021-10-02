class Solution {
    public int countSubstrings(String s) {
        
        int count =0; // to count the number of palindrom
        
        //Loop through the string in O(n)
        for(int i =0;i<s.length();i++){
            int oddCount = expandFromCenter(s,i,i)            ;
            int evenCount = expandFromCenter(s,i,i+1);
            count = count + oddCount + evenCount;
        }
        
        return count;
    }
    
    public int expandFromCenter(String s,int left,int right){
        int count =0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
        
        return count;
    }
}