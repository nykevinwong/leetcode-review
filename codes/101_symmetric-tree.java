
/*
   有效的鏡像對稱二元樹所需條件:
   (1) 樹根節點或子樹根節點與自已對稱，函式可以傳兩個同一根節點，自已比較自已.
   (2) 當前左節點值等於當前右節點值.
   (3) 當前左節點的右值與當前右節點的左值相等。反之  
        
例子:當前左右節點同時都空值時，當前節點也是有效鏡像二元子樹.
       當前左右節點只有一個為空值，代表不相等，不是有效鏡像二元子樹。    
       
*/
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    
    public boolean isMirror(TreeNode left, TreeNode right)
    {
        if(left == null && right == null) return true;
        if(left==null || right == null) return false;
        
        return (left.val == right.val) && 
            isMirror(left.left, right.right) &&
            isMirror(left.right,right.left);
    }