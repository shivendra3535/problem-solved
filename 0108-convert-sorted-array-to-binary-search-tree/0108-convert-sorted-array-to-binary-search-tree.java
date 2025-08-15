/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBST(int nums[],int numStart, int numEnd){
        if(numStart>numEnd)return null;
        int mid=(numStart+numEnd)/2;
        TreeNode root= new TreeNode(nums[mid]);
        root.left= createBST(nums,numStart,mid-1);
        root.right=createBST(nums,mid+1,numEnd);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums,0,nums.length-1);
    }
}