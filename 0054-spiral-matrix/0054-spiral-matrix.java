class Solution {
    public void spiral(int matrix[][],List<Integer> res,int sR, int eR, int sC, int eC){
        for(int i=sC; i<=eC; i++){
            res.add(matrix[sR][i]);
        }
        for(int i=sR+1; i<=eR; i++){
            res.add(matrix[i][eC]);
        }
        if(sR<eR){
          for(int i=eC-1; i>=sC; i--){
            res.add(matrix[eR][i]);
          }
        }
        if(sC<eC){
        for(int i=eR-1; i>sR; i--){
            res.add(matrix[i][sC]);
        }
        }
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res= new ArrayList<>();
        int sR=0;
        int eR=matrix.length-1;
        int sC=0;
        int eC=matrix[0].length-1;
        while(sR<=eR && sC<=eC){
           spiral(matrix,res,sR,eR,sC,eC);
           sR++;
           eR--;
           sC++;
           eC--;
        }
        return res;
    }
}