
public TreeNode insertIntoBST(TreeNode root, int val) {
    if(root==null) return new TreeNode(val);
    
    if(root.val > val) root.left = insertIntoBST(root.left, val);                
    if(root.val < val) root.right = insertIntoBST(root.right, val);        
    
    return root;
}

//iterative approach   
public TreeNode insertIntoBST(TreeNode root, int val) {
    Stack<TreeNode> s = new Stack<>();

    if(root!=null) s.push(root);
        
    while(!s.isEmpty())
    {
        TreeNode node = s.pop();
        
        if(node.val < val) { 
            if(node.right==null) { node.right = new TreeNode(val); return root; }                
            s.push(node.right); 
        }            
        
        if(node.val > val) { 
            if(node.left==null) { node.left = new TreeNode(val); return root; }                
            s.push(node.left); 
        }            
    }
    
    return new TreeNode(val);
}