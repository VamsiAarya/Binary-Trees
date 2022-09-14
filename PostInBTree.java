class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int psIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        for(int i=0; i< inorder.length; i++){
            map.put(inorder[i], i);
        }
        psIndex= postorder.length-1;
        return build(inorder, postorder,0, inorder.length-1 );
    }
    
    public TreeNode build(int[] inorder, int[] postorder,int inStart,int inEnd){
        
        if(inEnd < inStart) return null;
        
        TreeNode root = new TreeNode(postorder[psIndex--]);
        
        if(inStart == inEnd) return root;
        
        if(root == null) return null;
        
        
        int indexOfRoot = map.get(root.val);
        
        root.right = build(inorder, postorder, indexOfRoot+1, inEnd);
        root.left = build(inorder, postorder, inStart, indexOfRoot-1);
        
        return root;
    }
}