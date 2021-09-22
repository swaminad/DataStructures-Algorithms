class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //Matrix data east =0, south = 1,west =2,north =3
        int  top =0,bottom = matrix.length-1,left =0,right = matrix[0].length-1;
        List<Integer> out = new ArrayList<Integer>();
        
        while(top <= bottom && left <= right){
            //Move right Here row is constant which is top and i is moving from left to right
            for(int i = left;i<=right;i++)
                out.add(matrix[top][i]);
            top++;
            
            //Move down here column is constant which is right and i is moving from top to bottom
            for(int i=top;i<=bottom;i++){
                out.add(matrix[i][right]);
            }
            right--;
            //Move left here row is constant which is bottom and i is moving from right to left
            if(top <= bottom){//Becoz top value is changed so need to check before moving left
                for(int i = right; i>=left;i--)
                    out.add(matrix[bottom][i]);
                bottom--;      
            }
            //Move Up here column is constant which is left and i is moving from bottom to up
            if(left <= right){//Becoz right value is changed so need to check before moving up
                for(int i = bottom; i >=top;i--)
                    out.add(matrix[i][left]);
                left++;
            }
        }
        return out;
    }
}