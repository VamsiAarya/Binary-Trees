public class SameTree {
    public boolean isSame(Node root1, Node root2){
        
        if(root1 == null || root2 ==null) return root1==root2;
        
        boolean left = isSame(root1.left, root2.left);
        boolean right = isSame(root1.right, root2.right);

        return root1.val == root2.val && left && right;
        
    }
    
    public boolean isSameTree(Node p, Node q) {
        boolean ans = isSame(p, q);
        return ans;
    }
}
