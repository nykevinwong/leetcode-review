/*
區間長度公式為兩數差的絕對值+1.
公式不受基底起始索引值的影嚮.

中序陣列元素值對索引對照表對解中序陣列題可能有用.

中序陣列左右子樹大小:
零基底陣列表示是從左到右。索引值從0到n.
中序陣列右子樹的區間大小 inLeftTreeLen = 陣列右邊界索引值 -  中序當前根節點索引值.
中序陣列右子樹的區間大小 inRightTreeLen= 中序當前根節點索引值 - 陣列右邊界索引值.


停止或防止區間操作的條件:
某區間start 至 end，防止或停止區間外的操作可用 if(start > end) 來檢查並停止.
如果有多個區間，則任何區間符合防止操作條件就可停止.

中序左右子樹區間範圍:
如果已知中序節點索引值rootIndex, 左子樹為 (inStart, rootIndex-1)，右子樹為(rootIndex+1, inEnd).

前序陣列左右子樹區間範圍:
 左子樹為(preStart+1, preEnd - 右子樹大小) , 右子樹為 (preEnd- 右子樹大小+1, preEnd)

後序陣列左右子樹區間範圍:
 左子樹為(postStart, postStart+左子樹大小-1) , 右子樹為 (poStart+左子樹大小, postEnd-1)

node.left = buildTree(inorder, postorder,
        inStart, rootIndex -1,
        poStart, poStart + leftTreeLen -1, m);
        
 
 node.right = buildTree(inorder, postorder,
         rootIndex+1, inEnd,
         poStart + leftTreeLen, poEnd -1, m);
       
*/

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inPos = new HashMap<Integer,Integer>();
        
        for(int i=0;i< inorder.length;i++)
        {
            inPos.put(inorder[i], i);
        }
        
        return buildTree(inorder, preorder, 0, inorder.length-1, 0, preorder.length-1, inPos);
    }
    
    public TreeNode buildTree(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart, int preEnd,  Map<Integer,Integer> inPos)
    {
        if(inStart > inEnd || preStart > preEnd ) return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        int rootIndex = inPos.get(preorder[preStart]);  
        int rightTreeLen = inEnd - rootIndex;
        int leftTreeLen = rootIndex - inStart;
       
        node.left = buildTree(inorder, preorder, 
                              inStart, rootIndex-1, 
                               preStart+1,  preEnd - rightTreeLen, inPos);      
        node.right = buildTree(inorder, preorder, 
                              rootIndex + 1, inEnd,  
                               preEnd- rightTreeLen + 1, preEnd, inPos);
        
        return node;
    }