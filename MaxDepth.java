import java.util.*;

public class MaxDepth {

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


    private static int maxDepth(Node root){

        if(root == null){
            return 0;
        }

        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right) );
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

        int ans = maxDepth(root);

        System.out.println(ans);
        in.close();
    }
}
