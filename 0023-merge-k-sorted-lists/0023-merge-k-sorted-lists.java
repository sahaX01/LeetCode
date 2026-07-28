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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        if (lists.length == 0)
            return null;

        for (int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];
            while (curr != null) {
                pq.add(curr);
                curr = curr.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            ListNode next = node.next; // save (not actually needed in your approach)
            node.next = null; // disconnect from original list

            curr.next = node;
            curr = curr.next;
        }

        return dummy.next;
    }
}