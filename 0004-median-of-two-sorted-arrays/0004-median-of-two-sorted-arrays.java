class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l1 = nums1.length;
        int l2 = nums2.length;

        if (l1 > l2)
            return findMedianSortedArrays(nums2, nums1);

        int N = (l1 + l2 + 1) / 2;

        int low = 0;
        int high = l1;

        while (low <= high) {

            int mid1 = low + (high - low) / 2;
            int mid2 = N - mid1;

            int a1 = mid1 > 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int a2 = mid2 > 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;

            int r1 = mid1 < l1 ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < l2 ? nums2[mid2] : Integer.MAX_VALUE;

            if (a1 <= r2 && a2 <= r1) {

                if ((l1 + l2) % 2 == 0) {
                    return ((double)Math.max(a1, a2)
                            + Math.min(r1, r2)) / 2.0;
                }

                return Math.max(a1, a2);
            }

            else if (a1 > r2) {
                high = mid1 - 1;
            }

            else {
                low = mid1 + 1;
            }
        }

        return -1;
    }
}