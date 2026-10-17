import java.util.*;

class Pair {
    int num;
    int idx;

    Pair(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }
}

class Solution {
    public int sum(int num) {
        int s = 0;

        while (num > 0) {
            s += num % 10;
            num /= 10;
        }

        return s;
    }

    public int minSwaps(int[] nums) {
        Pair[] arr = new Pair[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        Arrays.sort(arr, (a, b) -> {
            int t = Integer.compare(sum(a.num), sum(b.num));

            if (t == 0) {
                return Integer.compare(a.num, b.num);
            }

            return t;
        });

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int cntSwap = 0;

        for (int i = 0; i < nums.length; i++) {
            int expected = arr[i].num;

            if (nums[i] != expected) {
                int expIdx = map.get(expected);
                int current = nums[i];

                nums[i] = expected;
                nums[expIdx] = current;

                map.put(expected, i);
                map.put(current, expIdx);

                cntSwap++;
            }
        }

        return cntSwap;
    }
}