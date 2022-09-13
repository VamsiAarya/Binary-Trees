class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int prStart =0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return build(preorder, inorder, 0, inorder.length-1);
    }
    
    public TreeNode build(int[] preorder, int[] inorder,int inStart,int inEnd){
        if(inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[prStart++]);
        
        if(root ==null) return null;
        
        if(inStart == inEnd) return root;
        
        int indexOfRoot = map.get(root.val);
        
        root.left = build(preorder, inorder, inStart, indexOfRoot-1);
        
        root.right = build(preorder, inorder, indexOfRoot+1, inEnd);
        
        return root;
        
    }
}