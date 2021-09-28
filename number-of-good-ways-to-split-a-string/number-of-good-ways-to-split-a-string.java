class Solution {
    public int numSplits(String s) {
        int n = s.length();
        //declare the prefix unquie and suffix unique
        int[] puni = new int[n];
        int[] suni = new int[n];
        
        HashSet<Character> set = new HashSet<Character>();
        //calculate the prefix unique
        for(int i =0;i<n;i++){
            set.add(s.charAt(i));
            puni[i] = set.size();
        }
        
        set.clear();
        
        //calculate the suffix unique
        for(int i = n-1 ;i>=0;i--){
            set.add(s.charAt(i));
            suni[i] = set.size();
        }
        
        int count = 0;
        //if unique char upto this - upto this from backwards should be 0
        for(int i =0;i<n-1;i++){
            if(puni[i] - suni[i+1] == 0)
                count++;
        }
            
        return count;
    }
}