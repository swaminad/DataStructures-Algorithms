class Solution {
    public String longestPalindrome(String s) {
       
        int maxSoFar = 0;
        String out = "";
        
        //Loop through the string and expandfromcenter
        for(int i =0;i<s.length();i++){
            int oddLen = expandFromCenter(s,i,i);
            int evenLen = expandFromCenter(s,i,i+1);
            int max = Math.max(oddLen,evenLen);
            if(max>maxSoFar){
                maxSoFar = max;
                System.out.println("Length is "+max+ " "+i);
                int left = i - (max-1)/2;
                int right = i + max/2;
                out = s.substring(left,right+1);
            }
        }
        return out;
        
        /*int strLength = s.length();
        String out = String.valueOf(s.charAt(0));
        String temp = "",reverse = null;
        
        for(int i=0; i < strLength; i++)
        {
            temp =  String.valueOf(s.charAt(i));
            for(int j=i+1;j<strLength;j++){
                temp = temp + s.charAt(j);
                reverse = reverse(temp);
              //  System.out.println("String is "+temp+" reverse is "+reverse);
                if(temp.equals(reverse) && temp.length() > out.length())
                    out = temp;
            }
        }
        
        return out;*/
        
    }
    
    public int expandFromCenter(String s,int left,int right){
        
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        
        return right -left -1;//since it is zero indexed we are subracting 1
    }
    
    public String reverse(String s){
        char[] strChar = s.toCharArray();
        char[] rev = new char[strChar.length];
        
        for(int i = 0; i < strChar.length; i++)
            rev[i] = strChar[strChar.length - i -1];
        
        return new String(rev);
    }
}