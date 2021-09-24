class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int row = text1.length();
        int col = text2.length();
        //declare the dp array
        int[][] dp = new int[row+1][col+1];
        
       // dp[0][0] = 1;
        
        for(int i =1;i<row+1;i++){
            for(int j=1;j<col+1;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
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