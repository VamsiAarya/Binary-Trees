import java.util.*;

public class BottomView {
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

    static TreeMap<Integer, int[]> map ;
    private static void topView(Node root, int col,int level) {
        if(root ==null) return;

        
        if(!map.containsKey(col)){
            int[] frst = {level,root.val};
            map.put(col, frst);
        }
        else{
            int[] arr = map.get(col);
            if(arr[0] <= level){
                arr [0] = level;
                arr[1] = root.val;
            }
        }
            
        topView(root.left, col-1, level+1);
        topView(root.right, col+1, level+1);
    }


    public static void main(String[] args) {
        map= new TreeMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++) nums[i] = in.nextInt();

        Node root = null;

        for(int i=0; i<n; i++){
           root= insertIntoBST(root, nums[i]);
        } 


        System.out.println("Bottom view");

        
        topView(root, 0 ,0);
        // System.out.println(map);

        String ans ="";
        for(Integer key : map.keySet()){
            ans += map.get(key)[1]+" ";
        }

        System.out.println(ans);

        in.close();
    }
}

// 8 3 1 4 2 0 -1 6 5
// Bottom view
// -1 0 1 2 5 6 