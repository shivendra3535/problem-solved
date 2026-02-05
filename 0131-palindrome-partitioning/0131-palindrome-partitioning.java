class Solution {
    public boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public void partition(String s, int index, List<List<String>>res, List<String> ds){
        if(index>=s.length()){
            res.add(new ArrayList<>(ds));
        }

        for(int i=index; i<s.length(); i++){
            if(isPalindrome(s,index,i)){
                ds.add(s.substring(index,i+1));
                partition(s,i+1,res,ds);
                ds.remove(ds.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>>res= new ArrayList<>();
        List<String> ds= new ArrayList<>();
        partition(s,0,res,ds);
        return res;
    }
}