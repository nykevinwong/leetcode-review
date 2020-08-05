import java.util.List; 

/* 
 前序遍歷可取得二元樹的拓排列資料. 前序先處理父節點，再來處理子節點.
 前序遍歷可用來實現目錄結構的顯示，也可從代達式樹建立prefix expression (Polish notation). "+*A-BC+DE"
 如果是文件夹，先输出文件夹名，然后再依次输出该文件夹下的所有文件(包括子文件夹). 
 如果有子文件夹，则再进入该子文件夹，输出该子文件夹下的所有文件名.
 这是一个典型的先序遍历过程.
*/

public List<Integer> preorderTraversal(TreeNode root)
{
    List<Integer> res = new ArrayList<>();
    dfs(root, res);
    return res;
}

public void dfs(TreeNode root, List<Integer> res)
{
    if(root==null) return;
    res.add(root.val);
    dfs(root.left);
    dfs(root.right);
}
