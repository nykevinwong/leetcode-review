import java.util.List;

/* 後序遍歷可用來
(1)實現計算目錄內文件佔用硬盤的資料大小
(2) 也可從代達式樹建立postfix expression (Reverse Polish notation).
 "ABC-*DE++". 
(3) 也可以用刪除節點，free記憶體，父節點只能在子節點記憶體free後，才能free自己的物件記憶體.
(4) 拷貝一個二元樹的過程，就是一個後序遍歷的過程.必須完全拷貝子樹後，才能拷貝父節點物件.

统计文件夹的大小过程如下：
若要知道某文件夹的大小，必须先知道该文件夹下所有文件的大小.
如果有子文件夹，若要知道该子文件夹大小，必须先知道子文件夹所有文件的大小。这是一个典型的后序遍历过程。

*/
public List<Integer> postorderTraversal(TreeNode root)
{
    List<Integer> res = new ArrayList<>();
    dfs(root, res);
    return res;
}

public void dfs(TreeNode root, List<Integer> res)
{
    if(root==null) return;
    dfs(root.left);
    dfs(root.right);
    res.add(root.val);
}
