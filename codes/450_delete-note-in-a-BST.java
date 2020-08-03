
public TreeNode deleteNode(TreeNode root, int value)
{
 if(root==null) return null; // nothing mathced.
 
 if(root.val > value)  
 {   //傳回值要傳給當前左節點
      root.left = deleteNode(root.left, value); 
 }
 else if(root.val < value) 
 {  //傳回值要傳給當前右節點
       root.right = deleteNode(root.right, value); 
 }
 else if(root.val==value)
 {   // cover 00, 01, 10 case
  if(root.left==null || root.right==null) // only one child node 
   return (root.left==null) ? root.right:root.left; 

        // 11 case. two childs
 TreeNode leftMostMinOnRight = root.right;  
  
  while(leftMostMinOnRight.left!=null) leftMostMinOnRight = leftMostMinOnRight.left;
  
  root.val = leftMostMinOnRight.val;
//傳回值要傳回給要刪的節點
  root.right = deleteNode(root.right, root.val);
  
 }

 return root; 
}