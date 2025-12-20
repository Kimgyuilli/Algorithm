import java.util.*;

class Solution {
    
    private int[][] result;
    private int idx;
    
    public class Node{
        int x, y, value;
        Node right, left;
        
        public Node(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    
    
    
    public int[][] solution(int[][] nodeinfo) {
        
        int nodeLength = nodeinfo.length;

        
        Node[] nodes = new Node[nodeLength];
        
        for(int i = 0; i < nodeLength; i++){
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }
        
        Arrays.sort(nodes, (n1, n2) -> 
                   n1.y == n2.y ? n1.x - n2.x : n2.y - n1.y
                   );
        
        Node root = nodes[0];
        for(int i = 1; i < nodeLength; i++){
            insertNode(root, nodes[i]);
        }
        
        result = new int[2][nodeLength];
        idx = 0;
        preOrder(root);
        idx = 0;
        postOrder(root);
        
        return result;
    }
    
    private void insertNode(Node parent, Node child){
        if (parent.x > child.x){
            if(parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
           if(parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }
    
    private void preOrder(Node node){
        if(node == null) return;
        result[0][idx++] = node.value;
        preOrder(node.left);
        preOrder(node.right);
    }
    
    private void postOrder(Node node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        result[1][idx++] = node.value;
    }
    
}