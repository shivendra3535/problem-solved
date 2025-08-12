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
    public TreeNode bstConstructor(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap){
        if(preStart>preEnd || inStart>inEnd) return null;
        TreeNode root= new TreeNode(preorder[preStart]);
        int inRootIndex=inMap.get(root.val);
        int numLeft= inRootIndex- inStart;
        root.left = bstConstructor(preorder, preStart + 1, preStart + numLeft, inorder, inStart, inRootIndex - 1, inMap);
        root.right = bstConstructor(preorder, preStart + numLeft + 1, preEnd, inorder, inRootIndex + 1, inEnd, inMap);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        Map<Integer, Integer> inMap= new HashMap<>();
        int []inorder= preorder.clone();
        Arrays.sort(inorder);
        for(int i=0; i<preorder.length; i++){
            inMap.put(inorder[i],i);
        }
        return bstConstructor(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inMap);
    }
}