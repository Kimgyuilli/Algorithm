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
    private ListNode list2;
    private int a, b;
    private ListNode start, end; 
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        this.list2 = list2;
        this.a = a;
        this.b = b;

        findNode(list1, 0);

        this.start.next = list2;

        connectToEnd(list2);
        
        return list1;
    }
    
    private void findNode(ListNode node, int depth) {
        if(depth + 1 == a) {
            this.start = node;
        } else if(depth == b) {
            this.end = node.next;
            return;
        }
        
        if(node.next != null) {
            findNode(node.next, depth + 1);
        }
        return;
    }

    private void connectToEnd(ListNode node) {
        if(node.next == null) {
            node.next = end;
            return;
        }
        connectToEnd(node.next);
    }
}