public class LCA {

    private static Node lca(Node root, Node p, Node q){
        if(root == null) return null;
        
        
        
        if(root== p || root == q) return root;
       
        
        Node leftPresent = lca(root.left, p, q);
        Node rightPresent = lca(root.right, p, q);
        
        if(leftPresent !=null && rightPresent !=null){
            return root;
        }
        
        if(leftPresent ==null && rightPresent ==null) return null;
        
        if(leftPresent!=null) return leftPresent;
        
        return rightPresent;
        
    }
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        Node ans = lca(root, p, q);
        return ans;
    }
}

