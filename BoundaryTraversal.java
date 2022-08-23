import java.util.*;

// We have to travel anti clockwise over the tree.
public class BoundaryTraversal {

    private static void preorderTraversal(Node root) {
        if(root == null){
            return;
        }

        System.out.print(root.val+" ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
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


    private static void addLeftNodes(Node root, Queue<Integer> qu) {
        
        Node temp = root;
        qu.add(temp.val);
        while(temp.left!=null && temp.right!=null){
            qu.add(temp.left.val);
            temp = temp.left;
        } 

        // System.out.println(qu);
    }

    private static void addLeaves(Node root, Queue<Integer> qu) {
        
        if(root == null) return;

        if(root.left == null && root.right ==null){
            qu.add(root.val);
        }

        addLeaves(root.left, qu);
        addLeaves(root.right, qu);

    }

    private static void addRightNodes(Node root, Queue<Integer> qu) {
        Node temp = root.right;
        Stack<Integer> stk = new Stack<Integer>();

        while(temp !=null){
            if(temp.right==null && temp.left==null){
                break;
            }
            stk.push(temp.val);
            temp = temp.right;
        } 

        // System.out.println("stk : "+ stk);
        while(stk.size() > 0) qu.add(stk.pop());
        System.out.println(qu);
        
    }

    // left nodes, leaf nodes, right nodes in reverse order
    private static void boundaryTraversal(Node root){
        Queue<Integer> qu = new LinkedList<>();

        addLeftNodes(root, qu);
        addLeaves (root, qu);
        // System.out.println(qu);
        addRightNodes(root,qu);
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
        System.out.println("BTraversal");
        boundaryTraversal(root);
        in.close();
    }
}

// Test case 
// 6 1 2 3 4 5 6
//  op : [1, 6, 5, 4, 3, 2]
// 8 3 1 4 2 0 -1 6 5
// [3, 1, 0, -1, 2, 5, 6, 4]