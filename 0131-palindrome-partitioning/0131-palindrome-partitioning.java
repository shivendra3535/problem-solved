class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> ans= new ArrayList<>();
        partition(s,0,ans,res);
        return res;
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    public void partition(String s,int index,List<String> ans, List<List<String>> res){
        if(index==s.length()){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i=index; i<s.length(); i++){
            if(isPalindrome(s, index, i)){
                ans.add(s.substring(index,i+1));
                partition(s,i+1,ans,res);
                ans.remove(ans.size()-1);
            }
        }
    } 
}