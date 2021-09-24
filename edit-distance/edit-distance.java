class Solution {
    public int minDistance(String word1, String word2) {
        //Declare the dp array
        int row = word1.length(), col = word2.length();
        int[][] dp = new int[row+1][col+1];
        
        //Assign the first row and first col
        for(int i =1;i<row+1;i++)
            dp[i][0] = i;
        for(int j = 1;j<col+1;j++)
            dp[0][j] =j;
        
        //Now fill up the dp array
        for(int i =1;i<row+1;i++){
            for(int j=1;j<col+1;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1]) + 1;
                }
            }
        }
        
        return dp[row][col];
    }
    
    public int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }
}