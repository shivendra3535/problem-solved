class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1=nums1.length;
        int l2=nums2.length;
        if(l1>l2) return findMedianSortedArrays(nums2,nums1);
        int left=0;
        int right=nums1.length;
        int n=(l1+l2+1)/2;
        while(left<=right){
            int mid=left+ (right-left)/2;
            int mid2=n-mid;
            int a1=Integer.MIN_VALUE;
            int a2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE;
            int r2=Integer.MAX_VALUE;
            
            if(mid-1>=0) a1=nums1[mid-1];
            if(mid2-1>=0) a2=nums2[mid2-1];

            if(mid<l1) r1=nums1[mid];
            if(mid2<l2) r2=nums2[mid2];

            if(a1<=r2 && a2<=r1){
                if((l1+l2)%2==0){
                    return (Math.max(a1,a2)+Math.min(r1,r2))/2.0;
                }
                else{
                    return (double)Math.max(a1,a2);
                }
            }
            else if(a1>r2) right=mid-1;
            else left=mid+1;
        }
        return (double)-1;
    }
}