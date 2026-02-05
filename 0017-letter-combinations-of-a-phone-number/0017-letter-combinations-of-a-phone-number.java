class Solution {
    public char [] map(char c){
        switch(c){
            case '2': return new char[]{'a','b','c'};
                      
            case '3': return new char[]{'d','e','f'};
                      
            case '4': return new char[] {'g','h','i'};
                      
            case '5': return new char[]{'j','k','l'};
                      
            case '6': return new char[]{'m','n','o'};
                      
            case '7': return new char[]{'p','q','r','s'};
                      
            case '8': return new char[]{'t','u','v'};
                      
            case '9': return new char[]{'w','x','y','z'};
                      

            default: return  new char[]{};
                     
        }
    }
    public void letterCombinations(int index,String digits,String s,List<String> res){
         if(index==digits.length()){
            res.add(s);
            return;
         }
         for(char c: map(digits.charAt(index))){
            String temp= new String(s);
            temp+=c;
            letterCombinations(index+1,digits,temp,res);
         }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res= new ArrayList<>();
        if(digits.length()==0) return res;
        letterCombinations(0,digits,"",res);
        return res;
    }
}