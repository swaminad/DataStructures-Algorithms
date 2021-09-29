class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       //Efficient solution using sort the char array
        HashMap<String,List<String>> map = new HashMap<>();
        
        for(String str:strs){
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = String.valueOf(charArr);
            map.putIfAbsent(key,new ArrayList<String>());
            map.get(key).add(str);            
        }
        
        return new ArrayList<List<String>>(map.values());
        
        
        /* //Base condition
        if(strs.length == 0) return null;
        
        Comparator<String> myCom = new Comparator<String>(){
            public int compare(String s1,String s2){
                if(s1.length()==s2.length()){
                    return 0;
                }else if(s1.length()>s2.length()){
                    return 1;
                }else{
                    return -1;
                }
                    
            }
        };
        //sort the array
        Arrays.sort(strs,myCom);
        
        System.out.println(Arrays.toString(strs));
        //Declare the output array
        List<List<String>> out = new ArrayList<>();
        boolean[] added = new boolean[strs.length];
        
        //Check the last element is empty then return empty
       
        /*if(strs.length == 1 && strs[0].equals("")){
            List<String> tmp = new ArrayList<String>();
            tmp.add("");
            out.add(tmp);
            return out;
        } */
        
        
        
       /* for(int i =0;i<strs.length;i++){
            if(added[i]) continue;
            
            List<String> temp = new ArrayList<String>();
            temp.add(strs[i]);
            added[i] = true;
            int sizei = strs[i].length();
            for(int j = i+1;j<strs.length;j++){
                if(!added[j]){//it is not added to any list
                    if(sizei != strs[j].length()) break;
                    if(anagram(strs[i],strs[j])){
                        temp.add(strs[j]);
                        added[j] = true;
                    }
                }                
            }
            out.add(temp);
        }
        
        return out;*/
    }
    
    public boolean anagram(String s,String t){
        if(s.length()!=t.length()) return false;
        //if it comes here then length will be same so no need for other conditions.
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i =0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)-1);
        }
        
        for(Integer val:map.values()){
            if(val != 0)return false;
        }
        return true;
    }
}