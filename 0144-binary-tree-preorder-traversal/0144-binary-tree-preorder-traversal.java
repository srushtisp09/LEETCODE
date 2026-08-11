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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null){
           return result;
        }
        //Integer is the wrapper class for the primitive int. Java automatically converts the primitive 0 into an Integer object for you — this is called autoboxing. Under the hood, it's roughly doing Integer.valueOf(0).
        result.add(root.val)  ;
      result.addAll( preorderTraversal(root.left));
      result.addAll( preorderTraversal(root.right));
    return result;
    }
}