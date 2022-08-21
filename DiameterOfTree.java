import java.util.*;

//Diameter : Longest path between any 2 nodes in a tree, may or may not pass through the root.

public class DiameterOfTree {


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

    static int dia;
    private static int diameter(Node root){
        if(root == null) return 0;

        int leftH = diameter(root.left);
        int rightH = diameter(root.right);

        dia = Math.max(dia, leftH+rightH );

        return 1+Math.max(leftH,rightH);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++) nums[i] = in.nextInt();
        Node root = null;

        //inserting to bst
        for(int i=0; i<n; i++){
            root= insertIntoBST(root, nums[i]);
            }

        System.out.println();
        dia =0;
        diameter(root);
        System.out.println(dia);

        in.close();
    }
}


// 8 3 1 4 0 -1 2 6 5

// 6