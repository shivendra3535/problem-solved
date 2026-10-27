class Solution {
    
    public String[] createGrid(int m, int n) {
        char grid[][]= new char[m][n];
        for(int i=0; i<m; i++) Arrays.fill(grid[i],'#');
        for(int i=0; i<m; i++){
            grid[i][0]='.';
        }
        for(int i=0; i<n; i++){
            grid[m-1][i]='.';
        }

        String ans[]= new String[m];
        int i=0;
        for(char a[]: grid){
            ans[i++]= new String(a);
        }
        return ans;
    }
}