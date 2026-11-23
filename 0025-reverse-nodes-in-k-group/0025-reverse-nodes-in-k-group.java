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
    public ListNode reverseGroup(ListNode ptr, ListNode kthNode) {
        ListNode prev = null;
        ListNode curr = ptr;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        int size = k;
        ListNode ptr = head;
        ListNode temp = head;
        ListNode newHead = null;
        ListNode prevTail = null;
        while (temp != null) {
            size--;
            if (size == 0) {
                ListNode kthNode = temp;
                ListNode next = temp.next;
                kthNode.next = null;
                ListNode reverse = reverseGroup(ptr, kthNode);

                if (newHead == null) {
                    newHead = reverse;
                } else {
                    // Connect previous group's tail to current group
                    prevTail.next = reverse;
                }
                ptr.next = next;

                prevTail = ptr;
                ptr = next;
                temp = next;
                size = k;
            } else {
                temp = temp.next;
            }

        }
        if (newHead == null) {
            return head;
        }

        return newHead;
    }
}