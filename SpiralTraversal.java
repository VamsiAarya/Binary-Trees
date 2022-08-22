import java.util.*;

public class SpiralTraversal {

    private static List<List<Integer>> spiralMaker(Node root) {
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
        
        List<List<Integer>> finalAns = new ArrayList<>();
        
        boolean flag = true;
        
        for(int i=0; i < ans.size(); i++){
            List<Integer>levl = new ArrayList<>(); 
            if(flag){
                for(int j=0; j< ans.get(i).size(); j++){
                    levl.add(ans.get(i).get(j).val);
                }
                flag= false;
            }
            else{
                for(int j=ans.get(i).size()-1; j>=0 ; j--){
                    levl.add(ans.get(i).get(j).val);
                }
                flag=true;
            }
            
            finalAns.add(levl);
        }
        
        return finalAns;
    }

    private static void lot1(Node root) {
        
        List<List<Integer>> ans = spiralMaker(root); 
        for(int i=0; i<ans.size(); i++){
            System.out.println("Level: "+ (i+1));
            for(int j=0; j< ans.get(i).size(); j++){
                System.out.print(ans.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public void zigzagLevelOrder(Node root) {
        //uncomment while submitting in leetcode
        // if(root ==null) return new ArrayList<>() ;
        lot1(root);
    }
}
