class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> output = new HashSet<>();
        
        recursion(candidates,target,0,new ArrayList<Integer>(),0,output);
        
        List<List<Integer>> outputFinal = new ArrayList<>();
        
        for(List<Integer> i:output)
            outputFinal.add(i);
        return outputFinal;
    }
    
    public void recursion(int[] candidates,int target,int currDig,List<Integer> currList,int currSum,Set<List<Integer>> output){
        
        //base condition
        if(currSum>=target || currDig == candidates.length){
            if(currSum == target){
                output.add(currList);
            }
            
            return;
        }
        
        //Don't choose current and move to next
        List<Integer> curr2 = new ArrayList<>();
        curr2.addAll(currList);
        recursion(candidates,target,currDig+1,curr2,currSum,output);
        
        //choose current and move to next
        List<Integer> curr = new ArrayList<>();
        curr.addAll(currList);
        curr.add(candidates[currDig]);
        recursion(candidates,target,currDig,curr,currSum+candidates[currDig],output);
        
        //choose current and don't move to next
        List<Integer> curr1 = new ArrayList<>();
        curr1.addAll(currList);
        curr1.add(candidates[currDig]);        
        recursion(candidates,target,currDig,curr1,currSum+candidates[currDig],output);
    }
        
        
}