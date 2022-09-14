class Solution {
    Queue<TreeNode> qu = new LinkedList<>();
    public void flatten(TreeNode root) {
        
        addTo( qu, root );
        TreeNode current = qu.poll();
        while(!qu.isEmpty()){
            
            TreeNode nextNode = qu.poll();
            
            current.right = nextNode;
            current.left = null;
            
            current = current.right;
        }
        
    }
    
    public void addTo(Queue<TreeNode> qu, TreeNode root){
        
        if(root == null) return;
        
        qu.offer(root);
        
        addTo(qu, root.left);
        
        addTo(qu, root.right);
        
        
    }
}