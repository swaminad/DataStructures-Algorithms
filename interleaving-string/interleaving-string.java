class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
       
        //base Condition
        if(s1.length()+s2.length() != s3.length())
            return false;
        
        //declare the dp array
        boolean[][] dp =new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        //fill the 0th row. 0th row will be s2 so check s3 with s2 string
        for(int i = 0;i<s2.length()+1;i++){
            if(s2.substring(0,i).equals(s3.substring(0,i)))
                dp[0][i] = true;
        }
        
        //fill the 0th col. 0th col will be s1 so check s3 with s1 string
        for(int i = 0;i<s1.length()+1;i++){
            if(s1.substring(0,i).equals(s3.substring(0,i)))
                dp[i][0] = true;
        }
        
        //fill the array if i of s1 is matching then (i-1)(j) should have been mathched before. likewise if j of s2 is matching then (i)(j-1) should have been mathched before
        
        for(int i = 1;i<s1.length()+1;i++){
            for(int j=1;j<s2.length()+1;j++){               
                dp[i][j] = (dp[i-1][j] && (s1.charAt(i-1) == s3.charAt(i+j-1))) || (dp[i][j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1)));
            }
        }
       
        return dp[s1.length()][s2.length()];
    }
}