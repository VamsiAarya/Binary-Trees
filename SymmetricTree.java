public class SymmetricTree {
    // Leetcode solution.
    class Solution {
    
        public boolean symmetric(Node left, Node right){
            if(left == null || right ==null){
                return left==right;
            }
            
            if(left.val !=  right.val){
                return false;
            }
                
            boolean leftResult = symmetric(left.left, right.right);
            boolean rightResult = symmetric(left.right, right.left);
            
            return leftResult && rightResult;
                
        }
        
        
        public boolean isSymmetric(Node root) {
            return symmetric(root.left, root.right);
        }
    }
}
