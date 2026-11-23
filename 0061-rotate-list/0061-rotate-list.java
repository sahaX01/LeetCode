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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        int n = 0;
        while(curr != null){
            n++;
            prev = curr;
            curr = curr.next;
        }
        prev.next = head;
        curr = head;
        k = k % n;
        int index = n - k;
        
        while(index-- > 1){
            curr = curr.next;
        }
        ListNode start = curr.next;
        curr.next = null;
        return start;
    }
}