// iterative approach

class BSTIterator {
    Stack<TreeNode> s= new Stack<>();
    TreeNode cur;
    
    public BSTIterator(TreeNode root) {
        cur = root;        
    }
    
    /** @return the next smallest number */
    public int next() {
        
        while(cur!=null)
        {
            s.push(cur);
            cur = cur.left;
        }
        
        cur = s.pop();
        int value = cur.val;
        
        cur = cur.right;
        return value;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur!=null || !s.isEmpty();
    }
}

// recursive approach

class BSTIterator {
    LinkedList<Integer> res = new LinkedList<>();
    
    public BSTIterator(TreeNode root) {
        dfs(root, res);
    }
    
    public void dfs(TreeNode root, List<Integer> res)
    {
        if(root==null) return;
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }
    
    /** @return the next smallest number */
    public int next() {
        return res.remove();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return res.size() > 0;
    }
}

