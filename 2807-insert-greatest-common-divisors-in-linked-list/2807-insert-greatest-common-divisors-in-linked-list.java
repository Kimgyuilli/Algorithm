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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        ListNode result = head;

        while(head.next != null) {
            int gcd = gcd(head.val, head.next.val);

            ListNode temp = new ListNode(gcd);

            temp.next = head.next;
            head.next = temp;
            
            head = temp.next;
        }
        return result;
    }

    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}