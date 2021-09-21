class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<String>();
        String temp = "";
        for(int i = 0;i<s.length();i++){
           // System.out.println(s.charAt(i));
            if(s.charAt(i) == ' '){
               if(!temp.equals("")) {
                   stack.add(temp);
                   temp = "";
               }
            }else{
                temp = temp + String.valueOf(s.charAt(i));
            }
        }        
        if(!temp.equals("")) stack.add(temp);
        
        String out = "";
        while(!stack.empty()){
            out = out + stack.pop()+ " ";
        }
        
        return out.substring(0,out.length()-1);
    }
}