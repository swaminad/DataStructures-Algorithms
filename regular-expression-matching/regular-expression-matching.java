class Solution {
    public boolean isMatch(String s, String p) {
      boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        //empty string can match with empty patten
        dp[0][0] = true;
        
        //empty string but patten is having like ".*.*.*etc" check the even characters is having * then check the previous even char and both true then assign dp[0][j-2]
        for(int j =2;j<=p.length();j++){
            if(p.charAt(j-1) == '*' && dp[0][j-2]){
                dp[0][j] = true;
            }
        }
        
        //
        for(int i = 1;i<=s.length();i++){
            for(int j = 1;j<=p.length();j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                    //if both characters are matching
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    char prevpChar = p.charAt(j-2);
                    if(prevpChar != '.' && prevpChar != s.charAt(i-1)){
                        //previous character of * in pattern is not matching with curr char of s string - no match of previous character of *
                        dp[i][j] = dp[i][j-2];
                    }else{
                        //previous character of * in pattern is having one or multiple match with current character of s string - one match or multiple match
                        dp[i][j] = (dp[i][j-2]||dp[i-1][j-2]||dp[i-1][j]);
                        //System.out.println("dp[i][j-2]::dp[i-1][j-2]::dp[i-1][j]"+dp[i][j-2] + " "+dp[i-1][j-2]+" "+dp[i-1][j]);
                    }
                }
             
            }            
        }
        
        
        return dp[s.length()][p.length()];
        
    }
}