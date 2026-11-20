class Solution {

    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public int findTheWinner(int n, int k) {

        Node head = new Node(1);

        int idx = 2;
        Node cur = head;

        while(idx <= n) {
            cur.next = new Node(idx++);
            cur = cur.next;
        }
        cur.next = head;

        head = cur;

        while(n > 1) {
            for(int i = 1; i < k; i++) {
                head = head.next;
            }

            head.next = head.next.next;
            n--;
        }

        return head.next.val;
    }
}