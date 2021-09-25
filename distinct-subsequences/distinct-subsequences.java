class Solution {
    public int numDistinct(String s, String t) {
        //assign the DP - t will be in row and s will be in column
        int[][] dp = new int[t.length()+1][s.length()+1];
        
        //fill the first row as 1 becoz empty string is always subsequence of non empty string only one time
        for(int i = 0; i<s.length()+1;i++){
            dp[0][i] = 1;
        }
        
        //fill the array
        for(int i = 1;i<t.length()+1;i++){
            for(int j = 1;j<s.length()+1;j++){
                if(t.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        
        return dp[t.length()][s.length()];
    }
}