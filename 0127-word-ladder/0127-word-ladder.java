class Solution {
    class Pair{
        String word;
        int steps;
        Pair(String word, int steps){
            this.word=word;
            this.steps=steps;
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
            String word=p.word;
            int step=p.steps;
            if(word.equals(endWord)) return step;
            for(int i=0; i<word.length(); i++){
                for(char ch='a'; ch<='z'; ch++){
                    char replaced[]= word.toCharArray();
                    replaced[i]=ch;
                    String rep= new String(replaced);
                    if(set.contains(rep)){
                        set.remove(rep);
                        queue.offer(new Pair(rep,step+1));
                    }
                }
            }
        }
        return 0;
    }
}