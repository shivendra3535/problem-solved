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
    public void partition(String s, int index, List<String> ds, List<List<String>> res){
        if(index>=s.length()){
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i=index; i<s.length(); i++){
            if(isPalindrome(s,index,i)){
                String pt= s.substring(index,i+1);
                ds.add(pt);
                partition(s,i+1,ds,res);
                ds.remove(ds.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res= new ArrayList<>();
        List<String> ds= new ArrayList<>();
        partition(s,0,ds,res);
        return res;
    }
}