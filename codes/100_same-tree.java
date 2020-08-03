public boolean isSameTree(TreeNode p, TreeNode q) {        
    if(p==null && q==null) return true;        
    if(p==null || q==null) return false; // 01 10
    
    if(p.val != q.val) return false;
    
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
}

public boolean isSameNode(TreeNode p, TreeNode q) {        
    if(p==null && q==null) return true;        
    if(p==null || q==null) return false; // 01 10
    
    return (p.val == q.val);
}

public boolean isSameTreeIterative(TreeNode p, TreeNode q)
{
    Stack<TreeNode> s1 = new Stack<>();
    Stack<TreeNode> s2 = new Stack<>();
    
    s1.push(p);
    s2.push(q);
    
    while(!s1.isEmpty())
    {
        TreeNode a = s1.pop();
        TreeNode b = s2.pop();
        
        if(!isSameNode(a,b)) return false;   
        
        if(a!=null)
        {
            if(!isSameNode(a.left,b.left)) return false;                
            
            if(a.left!=null)
            {
                s1.push(a.left);
                s2.push(b.left);
            }

            if(!isSameNode(a.right,b.right)) return false;
            
            if(a.right!=null)
            {
                s1.push(a.right);
                s2.push(b.right);
            }
        }
        
        
        
    }
    return true;
    
}
