import java.util.*;

// if order doesnt matter this approach works
public class TopView {

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


    static String ans ="";
    static int maxColLeft, maxColRight;
    private static void topView(Node root, int col) {
        if(root ==null) return;

        
        if(col < maxColLeft ){
            ans += root.val+" ";
            maxColLeft = col;
        }
        
        if(col > maxColRight){
            ans+= root.val+" ";
            maxColRight =col;
        }
            
        topView(root.left, col-1);
        topView(root.right, col+1);
    }
    public static void main(String[] args) {
        maxColLeft = 0;
        maxColRight =0;
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

        System.out.println("Top view");
        ans += root.val+" ";
        topView(root, 0);
        System.out.println(ans);


        in.close();
    }
}
