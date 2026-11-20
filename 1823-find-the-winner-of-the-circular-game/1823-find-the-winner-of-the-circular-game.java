class Solution {

    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public int findTheWinner(int n, int k) {

        if(k == 1) return n;

        Node head = new Node(1);

        int idx = 2;
        Node cur = head;
        while(idx <= n) {
            cur.next = new Node(idx++);
            cur = cur.next;
        }
        cur.next = head;

        head = cur;
        idx = 0; 
        while(n > 1) {
            if(idx == k - 1) {
                head.next = head.next.next;
                n--;
                idx = 0;
            } else{
                head = head.next;
                idx++;
            }
        }

        return head.next.val;
    }
}