    
  public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        int left = depth(root.left);
        int right = depth(root.right);
        
        if (Math.abs(left - right) > 1) {
            return false;
        }
       
      return isBalanced(root.left) && isBalanced(root.right);   
    }
    
    public int depth(TreeNode root) {
        if (root == null) return 0;

        int left = depth(root.left);
        int right = depth(root.right);        
        return Math.max(left, right) + 1;
    }
    
    public int depthShort(TreeNode root) {
        if (root == null) return 0;

        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
    
    HashMap<TreeNode,Integer> m = new HashMap<>();
    public int depthDP(TreeNode root) {
        if (root == null) return 0;

        if(m.containsKey(root)) return m.get(root);
            
        int left = depth(root.left);
        int right = depth(root.right);        
        
        m.put(root, Math.max(left, right) + 1);
        return m.get(root);
    }


// dfs approach
    public int dfsHeight (TreeNode root) {
        if (root == null) return 0;
        
        int leftHeight = dfsHeight (root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight (root.right);
        if (rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1)  return -1;
        
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return dfsHeight (root) != -1;
    }
