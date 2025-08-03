/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean getPath(TreeNode root, TreeNode x, ArrayList<TreeNode> res){
        if(root==null){
            return false;
        }
        res.add(root);
        if(root==x){
            return true;
        }
        if(getPath(root.left,x,res) || getPath(root.right,x,res)){
            return true;
        }
        res.remove(res.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root== null) return root;
        ArrayList<TreeNode> path1= new ArrayList<>();
        ArrayList<TreeNode> path2= new ArrayList<>();
        boolean p1= getPath(root,p,path1);
        boolean q1= getPath(root,q,path2);
        ArrayList<TreeNode> common= new ArrayList<>();
        int length;
        if(path1.size() >= path2.size()){
            length=path2.size();
        }
        else{
            length=path1.size();
        }
        for(int i=0; i<length; i++){
            if(path1.get(i)==path2.get(i)){
                common.add(path1.get(i));
            }
        }
        return common.get(common.size()-1);
    }
}