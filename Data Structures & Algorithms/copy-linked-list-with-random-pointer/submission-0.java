/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node current = head;

        // Step 1: Clone nodes and insert them next to original nodes
        while (current != null) {
            Node cloned = new Node(current.val);
            cloned.next = current.next;
            current.next = cloned;
            current = cloned.next;
        }
        // Step 2: Copy random pointers

        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Detach the cloned list from the original list
        current = head;
        Node newHead = head.next;
        Node copy = newHead;
        while (current != null) {
            current.next = current.next.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            current = current.next;
            copy = copy.next;
        }
        return newHead; 
    }
}
