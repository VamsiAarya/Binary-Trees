import java.util.*;


// check if a given tree is balanced or not.
// balanced = at every node | height of left subtree - height of right subtree |<=1

public class CheckBalancedTree {

    private static Node insertIntoBST(Node root, int val){

        if(root == null){
            return new Node(val);
        }

        if(root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        else{
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }

    //method 1
    static boolean ans = true;
    private static int isBalanced(Node root) {
        if(root == null) return 0;

        int leftHeight = isBalanced(root.left);
        int rightHeigth = isBalanced(root.right);

        if(Math.abs(leftHeight-rightHeigth) > 1){
            ans = ans && false;
        }

        return 1+ Math.max(leftHeight, rightHeigth);
    }


    //method 2 - tweak the maxDepth code a little.
    // if we get the maxDepth then it's balanced, otherwise we will -1 as result.
    private static int maxDepth(Node root){

        if(root == null){
            return 0;
        }

        int leftH = maxDepth(root.left);
        int rightH = maxDepth(root.right);

        if(leftH ==-1 || rightH ==-1) return -1;

        if(Math.abs(leftH - rightH) >1) return -1;

        return 1+ Math.max(leftH, rightH);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++) nums[i] = in.nextInt();

        Node root = null;

        for(int i=0; i<n; i++){
           root= insertIntoBST(root, nums[i]);
        } 

        //method 1 results
        isBalanced(root);
        System.out.println(ans);

        //method 2 results
        int maxdepth = maxDepth(root);
        boolean method2Ans = maxdepth != -1 ? true : false;
        System.out.println(method2Ans);


        in.close();
    }
}


// 8 3 1 4 0 -1 2 6 5
// false

// 7 3 1 0 2 5 4 6
// true