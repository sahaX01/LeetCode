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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        
        ListNode temp = new ListNode();
        ListNode Head = temp;
        int carry = 0;
        while(ptr1 != null && ptr2 != null){
           int val = ptr1.val + ptr2.val + carry;
           if(val > 9){
            temp.val = val % 10;
            carry = val / 10;
           }else{
            carry = 0;
            temp.val = val;
           }     
           
           ptr1 = ptr1.next;
           ptr2 = ptr2.next;

           if(ptr1 != null || ptr2 != null){
            temp.next = new ListNode();
            temp = temp.next;
           }
        }
        
        while(ptr1 != null){
            int val = ptr1.val + carry;
           if(val > 9){
            temp.val = val % 10;
            carry = val / 10;
           }else{
            carry = 0;
            temp.val = val;
           }     
           
           ptr1 = ptr1.next;

           if(ptr1 != null){
            temp.next = new ListNode();
            temp = temp.next;
           }
        }
        
        while(ptr2 != null){
           int val = ptr2.val + carry;
           if(val > 9){
            temp.val = val % 10;
            carry = val / 10;
           }else{
            carry = 0;
            temp.val = val;
           }     
        
           ptr2 = ptr2.next;

           if(ptr2 != null){
            temp.next = new ListNode();
            temp = temp.next;
           }
        }
        if(carry != 0){
        temp.next = new ListNode();
        temp = temp.next;
        temp.val = carry;
        }
        return Head;
    }
}