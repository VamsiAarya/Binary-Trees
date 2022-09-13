/*
Same code as All nodes at a distance k from given node question.
Here we need to find the farthest node that's it.
 */
class Solution {
    public TreeNode parentFinder(TreeNode root, HashMap<TreeNode, TreeNode> parents, int start){
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add(root);
        
        TreeNode res= null;
        while(!qu.isEmpty()){
            TreeNode current = qu.poll();
            if(current.val == start) res= current;
            
            if(current.left!=null){
                parents.put(current.left, current);
                qu.add(current.left);
            }
            
            if(current.right!=null){
                parents.put(current.right, current);
                qu.add(current.right);
            }
        }
        
        return res;
    }
    
    
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        TreeNode startNode = parentFinder(root, parents, start);
        
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(startNode);
        visited.put(startNode, true);
        int currentLevel=0;
        
        while(!qu.isEmpty()){
            int size = qu.size();
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
        
        return currentLevel-1;
    }
}