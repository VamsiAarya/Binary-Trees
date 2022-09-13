/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public void parentFinder(TreeNode root, HashMap<TreeNode, TreeNode> parents ){
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add(root);
        
        while(!qu.isEmpty()){
            TreeNode current = qu.poll();
            
            if(current.left!=null){
                parents.put(current.left, current);
                qu.add(current.left);
            }
            
            if(current.right!=null){
                parents.put(current.right, current);
                qu.add(current.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        parentFinder(root, parents);
        
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> qu = new LinkedList<>();
        
        qu.add(target);
        visited.put(target, true);
        int currentLevel=0;
        while(!qu.isEmpty()){
            int size = qu.size();
            if(currentLevel == k) break;
            currentLevel++;
            for(int i=0; i<size; i++){
                TreeNode current = qu.poll();
            
                if(current.left!=null && visited.get(current.left)==null){
                    qu.add(current.left);
                    visited.put(current.left, true);
                }

                if(current.right!=null && visited.get(current.right)==null){
                    qu.add(current.right);
                    visited.put(current.right, true);
                }
                TreeNode pNode = parents.get(current);
                if(pNode!=null && visited.get(pNode)==null){
                    qu.add(pNode);
                    visited.put(pNode, true);
                }
            } 
        }
        
        List<Integer> res = new ArrayList<>();
        
        while(!qu.isEmpty()){
            TreeNode n = qu.poll();
            res.add(n.val);
        }
        
        
        return res;
        
    }
}