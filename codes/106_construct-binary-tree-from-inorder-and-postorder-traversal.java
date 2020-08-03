public TreeNode buildTree(int[] inorder, int[] postorder)
{
  Map<Integer,Integer> m = new HashMap<>();
  
  for(int i=0;i< inorder.length;i++) { m.put(inorder[i],i); }
  
  return buildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1, m);
}

/*               
 [1 2 3 7 8 9 5]
     
     
 [1 2 3 5 7 8 9]
 
 next subTree interval in recusive calls
 
 post left Tree (poStart, poStart + leftTreeLen -1 )
 post right Tree (poStart + leftTreeLen, poEnd -1 )
 
 in left Tree (inStart, rootIndex -1)
 in right Tree(rootIndex+1, inEnd)
 
*/

public TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int poStart, int poEnd, Map<Integer,Integer> m)
{
 // When it's out of index boundary
 if(inStart > inEnd || poStart > poEnd) return null;
 
 TreeNode node = new TreeNode(postorder[poEnd]);
 int rootIndex = m.get(postorder[poEnd]);
 int leftTreeLen = rootIndex - inStart;
 int rightTreeLen = inEnd - rootIndex;
 
 node.left = buildTree(inorder, postorder,
        inStart, rootIndex -1,
        poStart, poStart + leftTreeLen -1, m);
        
 
 node.right = buildTree(inorder, postorder,
         rootIndex+1, inEnd,
         poStart + leftTreeLen, poEnd -1, m);
       

 return node;
}