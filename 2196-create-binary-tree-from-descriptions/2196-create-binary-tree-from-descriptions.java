/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {

        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> childSet = new HashSet<>();

        for(int[] node : descriptions) {
            int parent = node[0];
            int child = node[1];
            int isLeft = node[2];
            
            if(!nodeMap.containsKey(parent)) {
                nodeMap.put(parent, new TreeNode(parent));
            }
            if(!nodeMap.containsKey(child)) {
                nodeMap.put(child, new TreeNode(child));
            }

            if(isLeft == 1) {
                nodeMap.get(parent).left = nodeMap.get(child);
            } else {
                nodeMap.get(parent).right = nodeMap.get(child);
            }
            childSet.add(child);
        }

        for(int key : nodeMap.keySet()) {
            if(!childSet.contains(key)) {
                return nodeMap.get(key);
            }
        }
        
        return null;
    }
}