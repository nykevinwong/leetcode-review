/*
geek-for-geek solution

單值樹根節點值與左右節點值相同，代表此樹是根節點. 以此後序遍歷整個樹.
單值樹(uniValue) 空節點代表一個有效節點，傳回真。但節點不代表一個樹，不能計算成一個uniValue.
單值樹題用排除法及後序遍歷來解比較容易.

七言絕句:
單值樹根左右等     //題目及單值樹特性1 
空節點真不為樹     //單值樹空節點特性
後序遍歷排除解     //RECURSIVE解法
所有孩值為當值.    //如果是多元樹，要記得這點.
任一假非單值樹
當值非左值為假
當值非右值為假
計樹數量傳回真
*/

  public int countUnivalSubtrees(TreeNode root) {
    // Write your solution here
    int[] count = new int[1];
     isUniValueSubTree(root,count);
     return count[0];
  }

// apply bottom-up/postorder traversal approach
  public boolean isUniValueSubTree(TreeNode root, int[] count)
  {
      if(root==null) return true;

      boolean left = isUniValueSubTree(root.left, count);
      boolean right = isUniValueSubTree(root.right, count);

        // If any of the subtrees is not singly, then this 
        // cannot be singly. 

      if(left==false || right == false) return false;
      if(root.left!=null && root.left.key != root.key) return false;
      if(root.right!=null && root.right.key != root.key) return false;

      /// now the root's val and its value on left and right are the same.
      count[0]++;
      return true;
  }

boolean isUniValueSubTree(TreeNode node, int[] count)  
    { 
        // Return false to indicate NULL 
        if (node == null) 
            return true; 
           
        // Recursively count in left and right subtrees also 
        boolean left = countSingleRec(node.left, count); 
        boolean right = countSingleRec(node.right, count); 
   
        // If any of the subtrees is not singly, then this 
        // cannot be singly. 
        if (left == false || right == false) 
            return false; 
   
        // If left subtree is singly and non-empty, but data 
        // doesn't match 
        if (node.left != null && node.val != node.left.val) 
            return false; 
   
        // Same for right subtree 
        if (node.right != null && node.val != node.right.val) 
            return false; 
   
        // If none of the above conditions is true, then 
        // tree rooted under root is single valued, increment 
        // count and return true. 
        count[0]++; 
        return true; 
    } 