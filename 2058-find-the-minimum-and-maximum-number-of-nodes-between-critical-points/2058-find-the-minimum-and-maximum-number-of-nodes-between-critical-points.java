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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        ArrayList<Integer> ll = new ArrayList<>();
        ListNode dummy = head;
        int prev = -1;
        int curr = -1;
        int next = -1;
        for(int i=0; i<size-1; i++){
          prev = curr;
          curr = dummy.val;
          dummy = dummy.next;
          next = dummy.val;
          if(( prev != -1 && curr>prev && curr>next) || (prev != -1 && curr<prev && curr<next)){
            ll.add(i+1);
          }
        }

        if(ll.size()<2) return new int[]{-1, -1};
        
        int n = ll.size();
        int max = ll.get(n-1) - ll.get(0);
        int min = Integer.MAX_VALUE;
        for(int i=1; i<n; i++){
          int diff = ll.get(i) - ll.get(i-1);
          min = Math.min(min, diff);
        }

        return new int[]{min, max};
    }
}