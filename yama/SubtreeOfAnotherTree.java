

class SubtreeOfAnotherTree implements IInterviewQuestion
{
    public boolean isSubtree(TreeNode s, TreeNode t) {        
        return s!=null && (
            sameStructure(s,t) || //根節點樹是否等於傳入的樹t
            isSubtree(s.left,t) || //左節點樹是否等於傳入的樹t
            isSubtree(s.right,t)  //右節點樹是否等於傳入的樹t
        ); // 以此類推，是否某個節點樹等於傳入的樹t
    }
    
    public boolean sameStructure(TreeNode a, TreeNode b)
    {
        if(a==null && b ==null) // 空值樹是相同結構
            return true;
        
        if(a!=null && b !=null &&
          a.val == b.val) // 當前節點相等，就往下檢查該子樹的節點是否都相等
        {   //對同位左右節點比較      
            return sameStructure(a.left, b.left) && sameStructure(a.right, b.right);
        }   
        
        return false;
    }

    public void performTest()
    {
        TreeNode s = TreeNode.createBinaryTreeFromArray(new Integer[]{3,4,5,1,2});
        TreeNode t = TreeNode.createBinaryTreeFromArray(new Integer[]{4,1,2});
        System.out.println("is Subtree? " + isSubtree(s, t));
        TreeNode s0 = TreeNode.createBinaryTreeFromArray(new Integer[]{3,4,5,1,2,null,null,0});
        TreeNode t0= TreeNode.createBinaryTreeFromArray(new Integer[]{4,1,2});
        System.out.println("is Subtree? false => (expect false) " + isSubtree(s0, t0));
        TreeNode s1 = TreeNode.createBinaryTreeFromArray(new Integer[]{1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,2});
        TreeNode t1 = TreeNode.createBinaryTreeFromArray(new Integer[]{1,null,1,null,1,null,1,null,1,null,1,2});
        System.out.println("is Subtree? " + isSubtree(s1, t1));
        TreeNode s2 = TreeNode.createBinaryTreeFromArray(new Integer[]{1,1});
        TreeNode t2 = TreeNode.createBinaryTreeFromArray(new Integer[]{1});
        System.out.println("is Subtree? " + isSubtree(s, t));
    }
   
    public String toString() { 
        return "Subtree of Another Tree ([I] *) [https://leetcode.com/problems/subtree-of-another-tree/]";
    }
}
