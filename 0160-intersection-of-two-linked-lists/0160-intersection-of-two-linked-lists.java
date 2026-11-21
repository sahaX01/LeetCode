/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode first = headA;
        ListNode second = headB;
        while (headA != headB) {
            if (headA == null) {
                headA = second;
            } else {
                headA = headA.next;
            }
            if (headB == null) {
                headB = first;
            } else {
                headB = headB.next;
            }

        }

        return headA;
    }
}