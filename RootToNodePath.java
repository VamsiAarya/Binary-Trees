import java.util.*;

public class RootToNodePath {
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

    
    static ArrayList<Integer> ans;
    private static boolean findPath(Node root, int target) {
        
        if(root == null) return false;

        ans.add(root.val);

        if(root.val == target) return true;
        // System.out.println("add "+ans);
        boolean leftPresent = findPath(root.left, target);
        boolean rightPresent = findPath(root.right, target);

        if(leftPresent == false && rightPresent == false){
            ans.remove(ans.size()-1);
            // System.out.println("rem: "+ans);
        }

        return leftPresent || rightPresent;

    }
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++) nums[i] = in.nextInt();

        int target = in.nextInt();
        Node root = null;

        for(int i=0; i<n; i++){
           root= insertIntoBST(root, nums[i]);
        } 

        ans = new ArrayList<>();
        findPath (root, target);
        
        System.out.println("Path: "+ans);
       
        in.close();
    }
}

    //         3
    //        / \
    //       1   4
    //      / \    \
    //     0   2    6
    //    /        /
    // -1         5


// 8 3 1 4 2 0 -1 6 5
// 5
// Path: [3, 4, 6, 5]

// 8 3 1 4 2 0 -1 6 5
// 2
// Path: [3, 1, 2]