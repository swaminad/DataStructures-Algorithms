class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();
        
        //baseCondition
        if(digits.length() == 0) return output;
        //Generate the HashMap
        HashMap<Integer,List<String>> chars = generateLetterComHashMap();
        
       
        recursion(chars,digits,0,digits.length(),"",output);
        
        return output;        
    }
    
    public void recursion(HashMap<Integer,List<String>> chars,String digits,int currDig,int digLen,String currPos,List<String> output){
        //baseCondition if(currPos == currDig)
        if(digLen == currDig){
            output.add(currPos);
            return;
        }
        
        List<String> currDigitLetter = chars.get(Integer.parseInt(String.valueOf(digits.charAt(currDig))));
        
        //Calling the recursion
        for(int i =0;i<currDigitLetter.size();i++){            
            recursion(chars,digits,currDig+1,digLen,currPos+currDigitLetter.get(i),output);            }
        
        
    }
    
    public HashMap<Integer,List<String>> generateLetterComHashMap(){
        
        HashMap<Integer,List<String>> chars = new HashMap<>();
        
        chars.put(2,new ArrayList<String>(){
            {
                add("a");
                add("b");
                add("c");
            }
        });
        chars.put(3,new ArrayList<String>(){
            {
                add("d");
                add("e");
                add("f");
            }
        });
        chars.put(4,new ArrayList<String>(){
            {
                add("g");
                add("h");
                add("i");
            }
        });
        chars.put(5,new ArrayList<String>(){
            {
                add("j");
                add("k");
                add("l");
            }
        });
        chars.put(6,new ArrayList<String>(){
            {
                add("m");
                add("n");
                add("o");
            }
        });
        chars.put(7,new ArrayList<String>(){
            {
                add("p");
                add("q");
                add("r");
                add("s");
            }
        });
        chars.put(8,new ArrayList<String>(){
            {
                add("t");
                add("u");
                add("v");
            }
        });
        chars.put(9,new ArrayList<String>(){
            {
                add("w");
                add("x");
                add("y");
                add("z");
            }
        });
        
        
        return chars;
        
    }
}