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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result; 
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);
         List<Integer> currentLevel=new ArrayList<>();
        while(!q.isEmpty()){
           TreeNode curr=q.remove();
           if(curr==null){
            result.add(currentLevel);
            //The core concept: reference aliasing

// When you do containerB.add(objA) (or assign one reference variable to another), you are not copying the object — you're copying the reference (the address). Both variables now point to the same object. Any mutation through either name is visible through the other, until one of them is explicitly reassigned to point somewhere new.

// Where this bites you

// 1. Collecting results in a loop/recursion (exactly your currentLevel case)
// Anytime you build up a temporary list/object, stash it into a result container, and then want to "start fresh" — you must create a new object, not clear/reuse the old one.

// java
// List<Integer> temp = new ArrayList<>();
// temp.add(1);
// result.add(temp);
// temp.clear();          // BUG: also empties what's inside result!
// temp = new ArrayList<>();  // correct: fresh object, result untouched

// This exact pattern shows up in: level-order traversal (your case today), backtracking problems (subsets, permutations, combinations — where you build a path, add it to result, then backtrack), and DFS-collect-all-paths problems.

// 2. Backtracking — the single most common place this bug appears

// java
// List<Integer> path = new ArrayList<>();
// void backtrack(...){
//     path.add(x);
//     if(isValid) result.add(path);   // ⚠️ danger — same object!
//     backtrack(...);
//     path.remove(path.size()-1);     // this mutation also affects what's "saved" in result
// }

// The fix: result.add(new ArrayList<>(path)); — this makes a copy of path's current contents into a brand new list, so future mutations to path don't retroactively corrupt what's already saved in result. You will almost certainly hit this exact bug once you start subsets/permutations problems — good to have it in your head now.

// 3. Passing objects into methods (your call-by-value question from earlier)
// Same underlying idea: a method parameter is a copy of a reference. Mutating the object's fields through that parameter affects the original (shared object). Reassigning the parameter itself to a new object does not.

// 4. Two variables pointing at the same node/list

// java
// ListNode a = head;
// ListNode b = a;
// b.val = 100;   // this changes head's node too — a and b are the same object

// This is actually something you use on purpose constantly in linked list problems — e.g., ListNode tail = dummy; in your merge problem earlier. You want tail and dummy to reference the same node initially, precisely so that mutating through tail is visible through dummy.next later.

// The one question to ask yourself, every time

// "Do I want this new variable to be the same object (so mutations are shared), or a truly independent copy (so mutations don't leak back)?"

// Want shared → simple assignment (b = a) or add(a) — cheap, no new memory.
// Want independent → explicitly construct a new object: new ArrayList<>(), new ArrayList<>(existingList) (copy constructor), or manually copy fields.
            currentLevel=new ArrayList<>();
            if(q.isEmpty()){
                break;
            }else{
                 q.add(null);
            }
           } else{
            currentLevel.add(curr.val);
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
           }
        }


    return result;
    }
}