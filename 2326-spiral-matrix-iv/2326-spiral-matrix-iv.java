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
    public int[][] spiralMatrix(int m, int n, ListNode head) {

        final int[] DY = new int[] {1, 0, -1, 0};
        final int[] DX = new int[] {0, 1, 0, -1};

        int[][] answer = new int[m][n];

        for(int[] l : answer) {
            Arrays.fill(l, -1);
        }

        int x = 0;
        int y = 0;
        int dir = 0;

        while(head != null) {
            answer[x][y] = head.val;
            head = head.next;

            if(x + DX[dir] < 0 || x + DX[dir] >= m
            || y + DY[dir] < 0 || y + DY[dir] >= n
            || answer[x + DX[dir]][y + DY[dir]] != -1) {
                dir = (dir + 1) % 4;
            }

            x = x + DX[dir];
            y = y + DY[dir];
        }

        return answer;
    }
}