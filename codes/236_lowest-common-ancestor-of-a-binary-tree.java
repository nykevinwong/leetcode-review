/*
要找的節點都必須存在二元樹中，才能用此方法

查左右節點雙空，傳回空。
查任一空時，傳回不空。可以下面檢查.
if(left==null || right==null) // 00,01,10 covers 3 cases // return null or the other value.
            return (left==null) ? right:left;

use both top-down & bottom-up approach
*/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {        
        // this approach won't work if p or q doesn't exist in the binary tree
       if(root==null) return null;
        if(root==p || root==q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // return null for both null
        // return the one while the other is null.
        if(left==null || right==null) // 00,01,10 covers 3 cases // return null or the other value.
            return (left==null) ? right:left;
         
        return root;      // must use root since we want to ensure the top most ancestor is the answer  
    }