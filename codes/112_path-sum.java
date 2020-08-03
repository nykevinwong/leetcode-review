import java.util.Stack;
//top-down, preorder travesal approach
public boolean hasPathSum(TreeNode root, int sum) {
    if(root==null) return false;
    
    sum-=root.val;
    
    if(root.left==null && root.right==null)
        return sum==0;
    
    return hasPathSum(root.left, sum) | hasPathSum(root.right, sum);        
}

//iterative solution:

public boolean hasPathSum(TreeNode root, int sum) {
        Stack<Object[]> s = new Stack<>();
        
        if(root!=null) s.push(pair(root, sum));
    
        while(!s.isEmpty())
        {
            Object[] nodes = s.pop();
            TreeNode node = (TreeNode)nodes[0];
                                          
            Integer curSum = (Integer)nodes[1] -  node.val;
            
            if(node.left==null && node.right==null && curSum==0) return true;
            
            // you must push right node first before left node when you want to process left first and then right.
            // preorder traversal always process left first and then right.
            if(node.right!=null) s.push(pair(node.right,curSum) );
            if(node.left!=null) s.push(pair(node.left,curSum));
        }
    
    return false;
}

public Object[] pair(TreeNode a, Integer sum)
{
    return new Object[] { a, sum};
}