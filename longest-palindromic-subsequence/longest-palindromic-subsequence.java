class Solution {
    public int longestPalindromeSubseq(String s) {
        int row = s.length();
        int col = s.length();
        //reverse the string s
        String rev = new StringBuilder(s).reverse().toString();
        
        //declare the dp array
        int[][] dp = new int[row+1][col+1];
        
        for(int i=1;i<row+1;i++){
            for(int j=1;j<col+1;j++){
                if(s.charAt(i-1) == rev.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = max(dp[i-1][j-1],dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[row][col];
    }
    
    public int max(int a,int b,int c){
        return Math.max(a,Math.max(b,c));
    }
}