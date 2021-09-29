class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t== null) return true;
        if(s== null || t== null) return false;
        if(s.length()!=t.length()) return false;
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        //loop through the string
        for(int i = 0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1); //Increment the count
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)-1); //Decrement the count
        }
        
        //Check all character count is zero
        for(Integer val:map.values()){
            if(val != 0)
                return false;
        }
        
        return true;
        
    }
}