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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
       ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy;
        int count = 0;
        while(count <=n) {
            count++;
            if (first == null) return head;
            first = first.next;
        }
      

        while(first!=null) {
            first = first.next;
            second = second.next;
        }
        System.out.println(second.val);

       second.next = second.next.next;
        return dummy.next;


    }
}
