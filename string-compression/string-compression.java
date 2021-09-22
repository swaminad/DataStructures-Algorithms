class Solution {
    public int compress(char[] chars) {
        //pointer to output & count & prev
        int k =0,count = 0;
        char prev = chars[0];
        
        for(int i =0;i<=chars.length;i++){//loop through the array
            // System.out.println("Prev is "+prev+" current char "+" k is "+k+" count is "+count+" i is "+i);
            //prev and curr is same
            if(i<chars.length && prev == chars[i]){
                count++;
            }
            if(i == chars.length || i < chars.length && prev != chars[i]){//prev and cur is not same and if it is after the last character        
                    chars[k] = prev;
                    k++;
                   if(i < chars.length) prev = chars[i];
                if(count != 1 ){//if count is not one                                        
                    List<Integer> countList = new ArrayList<Integer>();
                    while(count > 0){
                        countList.add(count%10);
                        count = count/10;
                    }
                    for(int j = countList.size()-1;j>=0;j--){
                        chars[k] = countList.get(j).toString().charAt(0);
                        k++;
                    }
                    count =1;//assigning back to 1 for current character
                 }
            }
        }
        
            return k;
            
        }
        
    
}