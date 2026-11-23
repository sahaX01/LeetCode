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
        if (head == null)
            return null;
        Node temp = head;

        // 1. create copy node and insert them between 2 nodes
        while (temp != null) {
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = copyNode.next;
        }

        // 2. connect random pointer of each copy node 
        temp = head;
        while (temp != null) {
            Node copyNode = temp.next;
            if (temp.random == null) {
                copyNode.random = temp.random;
            } else {
                copyNode.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // 3. connect next pointer of each copy node to each other (copy node)

        Node res = new Node(-1);
        res.next = head.next;
        temp = head;
        while (temp != null) {
            Node copyNode = temp.next;
            temp.next = copyNode.next;
            if (copyNode.next != null) {
                copyNode.next = copyNode.next.next;
            }

            temp = temp.next;
        }

        return res.next;
    }
}