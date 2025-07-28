class Solution {
    public boolean checkValidString(String s) {
        int low=0;
        int high=0;
        for(char a: s.toCharArray()){
            if(a=='('){
                low++;
                high++;
            }
            else if(a==')'){
                if(low>0) low--;
                high--;
            }
            else{
                if(low>0) low--;
                high++;
            }

            if(high<0){
                return false;
            }
        }
        return low==0;
    }
}