class Solution {
    class Pair{
        String words;
        int len;
        Pair(String words, int len){
            this.words=words;
            this.len=len;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set= new HashSet<>();
        for(String s: wordList){
            set.add(s);
        }
        Queue<Pair> queue= new LinkedList<>();
        queue.offer(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!queue.isEmpty()){
            Pair p=queue.poll();
            String word=p.words;
            int cur=p.len;
            if(word.equals(endWord)) return cur;
            for(int i=0; i<word.length(); i++){
                for(char a='a'; a<='z'; a++){
                    char arr[]=word.toCharArray();
                    arr[i]=a;
                    String word2= new String(arr);
                    if(set.contains(word2)){
                        queue.offer(new Pair(word2,cur+1));
                        set.remove(word2);
                    }
                }
            }
        }
        return 0;
    }
}