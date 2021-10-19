class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<String>();
        recursion(output,"",0,0,n);
        return output;
    }
    public void recursion(List<String> output,String s,int open,int close,int n){
        
        
        
        //Base condition if opena and close is equal to n
        if(open == n && close == n){
            output.add(s);
            return;
        }
        
        //if open is < close and add close
        if(close<open){
            recursion(output,s+")",open,close+1,n);
        }
        
        //if open is < n then we have space to add more parentheses
        if(open < n){
            recursion(output,s+"(",open+1,close,n);
        }
    }
}