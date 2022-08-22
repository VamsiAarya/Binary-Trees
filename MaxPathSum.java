// https://leetcode.com/problems/binary-tree-maximum-path-sum/

public class MaxPathSum {
    static int max ;
    public int checkSum(Node root){
        if(root == null) return 0;
        
        //dont even consider if subtree is returning -ve sum.
        int leftSum = Math.max(0,checkSum (root.left));
        int rightSum = Math.max(0,checkSum(root.right));
        
        max = Math.max(max, leftSum+rightSum+root.val);
        
        return root.val+ Math.max(leftSum, rightSum);
    }
    
    public int maxPathSum(Node root) {
        max = Integer.MIN_VALUE;
        checkSum(root);
        
        return max;
    }
}
