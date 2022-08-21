import java.util.*;

// if the question is asked just to print all the nodes level wise order.
public class LevelOrderTraversal {

    public static void lot(Node root) {
        
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);

        while(qu.size() > 0){
            Node currentNode = qu.poll();
            if(currentNode.left != null){
                qu.add(currentNode.left);
            }

            if(currentNode.right != null){
                qu.add(currentNode.right);
            }

            System.out.print(currentNode.val+" ");
        }

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

        //inserting to bst
        for(int i=0; i<n; i++){
            root= insertIntoBST(root, nums[i]);
            }

        System.out.println();
        System.out.println("Level Order Traversal:");

        lot(root);
        in.close();
    }
}


// Test case:
// 8
// 3 1 4 0 -1 2 6 5

// output
// Level Order Traversal:
// 3 1 4 0 2 6 -1 5 