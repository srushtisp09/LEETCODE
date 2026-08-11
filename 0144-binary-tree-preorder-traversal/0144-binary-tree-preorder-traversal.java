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
        //root.val is just one int value (the current node's data). add() puts exactly that one item into the list. You can't use addAll() here because root.val isn't a collection — it's a single number, and addAll() requires a collection to merge in.
      result.addAll( preorderTraversal(root.left));
      //merges an entire collection into another collection
      //Here, preorderTraversal(root.left) is a recursive call — and remember, this method's return type is List<Integer>. So this call doesn't give you one value, it gives you back a whole list (the complete preorder traversal of the left subtree, which could have 0, 1, or many elements in it). You can't add() a list into a list of integers — that would try to insert the list itself as one element, which breaks the type (List<Integer> can't hold a List<Integer> as one of its Integer elements — type mismatch, won't compile). addAll() instead unpacks that returned list and appends each of its elements individually into result.
      result.addAll( preorderTraversal(root.right));
    return result;
    }
}