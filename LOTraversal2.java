import java.util.*;

//if question is asked to print elements of levels after grouping.

public class LOTraversal2 {

    private static ArrayList<ArrayList<Node>> ansMaker(Node root) {
        ArrayList<ArrayList<Node>> ans = new ArrayList<>(); 
        Queue<Node > qu = new LinkedList<>();
        qu.add(root);

        while(qu.size() > 0)
        {
            ArrayList<Node> currentLevelNodes = new ArrayList<>();
            while(qu.size() > 0) currentLevelNodes.add( qu.poll() );
            
            for(int i=0; i<currentLevelNodes.size(); i++){
                if(currentLevelNodes.get(i).left!=null){
                    qu.add(currentLevelNodes.get(i).left);
                }

                if(currentLevelNodes.get(i).right!=null){
                    qu.add(currentLevelNodes.get(i).right);
                }
            }

            ans.add(currentLevelNodes);
        }

        return ans;
    }



    //print bottom to top levels
    private static void lot2(Node root) {
        ArrayList<ArrayList<Node>> ans = ansMaker(root);
        
        for(int i= ans.size()-1; i>=0; i--){
            System.out.println("Level: "+ (i+1));
            for(int j=0; j< ans.get(i).size(); j++){
                System.out.print(ans.get(i).get(j).val+" ");
            }
            System.out.println();
        }
    }

    //print top to bottom levels
    private static void lot1(Node root) {
        ArrayList<ArrayList<Node>> ans = ansMaker(root);
        
        for(int i=0; i<ans.size(); i++){
            System.out.println("Level: "+ (i+1));
            for(int j=0; j< ans.get(i).size(); j++){
                System.out.print(ans.get(i).get(j).val+" ");
            }
            System.out.println();
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
        System.out.println("Top to Bottom");
        lot1(root);

        System.out.println();
        System.out.println("Bottom to Top");
        lot2(root);


        in.close();
    }
}

// Test case
// 8
// 3 1 4 0 -1 2 6 5

// op:
// Top to Bottom
// Level: 1
// 3 
// Level: 2
// 1 4 
// Level: 3
// 0 2 6 
// Level: 4
// -1 5 

// Bottom to Top
// Level: 4
// -1 5 
// Level: 3
// 0 2 6 
// Level: 2
// 1 4 
// Level: 1
// 3 