class Solution {
    public void rotate(int[][] matrix) {
        
        
        for(int i=0;i<=matrix.length-1;i++){
            
            for(int j=i+1;j<=matrix[0].length-1;j++){
              int temp=matrix[i][j];
              matrix[i][j]=matrix[j][i];
              matrix[j][i]=temp;
                  
            }
            
        }
         
       for(int i=0;i<matrix.length;i++){
         int left=0;
        int right=matrix.length-1;
         int[] row=matrix[i];
        while(left<right){
            int temp=row[left];
            row[left]=row[right];
            row[right]=temp;
            right--;
            left++;
        }
       }
             }
}