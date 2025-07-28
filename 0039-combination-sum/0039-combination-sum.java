import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(int index, List<Integer> ans, List<List<Integer>> res, int[] candidates, int target) {
        if (index == candidates.length) {
            if (target == 0) {
                res.add(new ArrayList<>(ans)); // Copy current combination
            }
            return res;
        }

        if (candidates[index] <= target) {
            ans.add(candidates[index]);
            combinationSum(index, ans, res, candidates, target - candidates[index]);
            ans.remove(ans.size() - 1);
        }
        combinationSum(index + 1, ans, res, candidates, target);

        return res;
    }
    
    // Wrapper function
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        return combinationSum(0, ans, res, candidates, target);
        
    }

    public static void main(String args[]) {
        Solution obj = new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int candidates[] = new int[n];
        
        for (int i = 0; i < n; i++) {
            candidates[i] = sc.nextInt();
        }
        List<List<Integer>> result = obj.combinationSum(candidates, target);

        System.out.println(result);
        sc.close();
    }
}
