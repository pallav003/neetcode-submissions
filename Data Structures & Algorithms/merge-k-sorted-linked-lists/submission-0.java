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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode output = null;
        for(int i = 1; i< lists.length;i++) {
            if (i==1) {
           output = mergeTwoLists(lists[i-1], lists[i]);
            }
            else {
                output = mergeTwoLists(output, lists[i]);
            }
        }
        return output;

    }

    public ListNode mergeTwoLists(ListNode first, ListNode second) {
        ListNode node = new ListNode(0);
        ListNode dummy = node;
        while(first!= null && second!=null) {
            if(first.val > second.val) {
                node.next = second;
                second = second.next;
            }
            else {
                node.next = first;
                first = first.next;
            }
            node = node.next;
        }
        while(first!= null) {
            node.next = first;
            first = first.next;
            node = node.next;
        }
        while(second!=null){
            node.next = second;
            second = second.next;
            node = node.next;
        }
        return dummy.next;
    }
}
