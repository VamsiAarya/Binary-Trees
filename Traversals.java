// Inserting in a BST and Pre, In , Post order Traversals.

import java.util.*;

// using recursion
class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class Traversals{

    private static void preorderTraversal(Node root) {
        if(root == null){
            return;
        }

        System.out.print(root.val+" ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
    
    // Inorder Traversal of BST is always in a sorted order (asc)
    private static void inorderTraversal(Node root) {
        if(root == null){
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.val+" ");
        inorderTraversal(root.right);
    }
    private static void postorderTraversal(Node root) {
        if(root == null){
            return;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.val+" ");
    }

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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++) nums[i] = in.nextInt();

        Node root = null;

        for(int i=0; i<n; i++){
           root= insertIntoBST(root, nums[i]);
        } 

        
        System.out.println("Pre order: ");
        preorderTraversal(root);
        System.out.println();
        System.out.println("In order: ");
        inorderTraversal(root);
        System.out.println();
        System.out.println("Post order: ");
        postorderTraversal(root);
        in.close();
    }
}