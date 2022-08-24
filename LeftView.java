import java.util.*;

public class LeftView {
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

    static TreeMap<Integer, Integer> map ;
    private static void leftView(Node root, int level) {
        if(root ==null) return;

        
        if(map.size() == level ){
            map.put(level, root.val);
        }
            
        leftView(root.left, level+1);
        leftView(root.right, level+1);
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


        System.out.println("Left view");

        
        leftView(root, 0 );
        // System.out.println(map);

        String ans ="";
        for(Integer key : map.keySet()){
            ans += map.get(key)+" ";
        }

        System.out.println(ans);

        in.close();
    }
}
