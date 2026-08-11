/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(-1);
         ListNode tail=dummy;
         while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                tail.next=list1 ;
                 list1=list1.next;
            }else{
                tail.next=list2;
                list2=list2.next;
            }
            tail=tail.next;
         }
         if(list1!=null){
            tail.next=list1;
         }else{
            tail.next=list2;
         }
         return dummy.next;
    }
}
///Good question — let's break it down.

// What it means:

// java
// ListNode dummy = new ListNode(-1);

// This creates a new node with value -1 and calls it dummy. It's not meant to hold real data — it's a placeholder node that sits before the actual head of your linked list, so you have a stable starting point to work from.

// Why we use a dummy node at all:

// When you're building or modifying a linked list (merging two lists, removing nodes, partitioning, etc.), the real head often changes during the process. If you try to track the head with a normal variable, you constantly have to handle special cases like "is this the first node I'm adding?"

// The dummy node sidesteps that. You do:

// java
// ListNode dummy = new ListNode(-1);
// ListNode tail = dummy;

// // ... build the list by doing tail.next = someNode; tail = tail.next;

// return dummy.next; // real head, dummy itself is discarded

// Since dummy.next always points to the true head once you're done, you never have to special-case "is this the first insertion."

// Can the value be 0 instead of -1?

// Yes — completely fine. The value you put inside the dummy node does not matter at all, because you never read or use dummy.val anywhere in your logic. You only ever use dummy.next. So:

// java
// ListNode dummy = new ListNode(0);

// works exactly the same as new ListNode(-1). Some people use -1 out of habit (to signal "this is clearly not a real value" if your list only ever contains non-negative numbers), but 0, -1, Integer.MIN_VALUE — all identical in effect. Pick whichever convention you like and stay consistent.

// One small tip since you're deep in linked list problems: if your problem does involve values that could be 0 or negative meaningfully, it's a good habit to still use something like -1 so it's visually obvious in your dry-runs which node is the dummy vs. a real data node — but functionally it changes nothing.


