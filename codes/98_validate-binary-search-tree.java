/*
有效的二元搜尋樹的特性是
(1)當前節點值大於左節點值及左子樹所有節點值，當前節點值小於右節點值及右子樹所有節點值.
(2)左右子樹必須是有效元二元搜尋樹，當前節點才是個有效二元樹.
(3)一個空節點是一個有效的二元搜尋樹.
(4)二元搜尋樹的左右邊界檢查可用Integer/Long Warpper Class,而且空值代表無限大.
*/
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null); // null means infinity here.
    }
    
    public boolean isValidBST(TreeNode root, Integer leftBound, Integer rightBound)
    {
        if(root==null) return true;
        
        if( (leftBound==null || leftBound < root.val) && (rightBound==null || root.val < rightBound) )
        {
            return isValidBST(root.left, leftBound, root.val) &&
                    isValidBST(root.right, root.val, rightBound);
        }
        
        return false;
    }