import java.lang.Math;
public int maxDepth(TreeNode node)
{
    //bottom-up/postorder recusrive approach
    
    if(node==null) return 0;
    
    int leftMax = maxDepth(node.left);
    int rightMax = maxDepth(node.right);
    
    return Math.max(leftMax, rightMax) + 1;
}