class Solution {
    public List<String> removeComments(String[] source) {
        boolean isBlock = false;
       
       
        List<String> out = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        
        for(int i =0;i<source.length;i++){
            
            for(int j=0;j<source[i].length();j++){
                System.out.println("i is "+ i + " j is "+ j);
                if(isBlock){
                    //Block comment Ends
                    if(source[i].charAt(j) == '*' &&j+1<source[i].length() && source[i].charAt(j+1) == '/'){                                       isBlock = false;                       
                            j++;                        
                    }
                }else{
                    //Line comment
                    if(source[i].charAt(j) == '/' && j+1 < source[i].length() && source[i].charAt(j+1) =='/'){                  
                        break;                                       
                    }else if(source[i].charAt(j) == '/' && j+1 < source[i].length() && source[i].charAt(j+1) == '*'){                    //Block comment Start                        
                        isBlock = true;
                        j++;
                    
                    }else{
                        sb.append(source[i].charAt(j));
                    }
                }            
            }
            
           
            if(!isBlock && sb.length()>0){
                out.add(sb.toString());
                sb = new StringBuilder();
            }         
        }
        
        return out;
    }
}