import java.util.List;

/* 
 中序遍歷(先遍歷左節點)可取得二元搜尋樹的升序排列資料.
 反向中序遍歷(先遍歷右節點)可取得二元搜尋樹的降序排列資料.
 二元搜尋樹跟二元樹的差別是，二元搜尋樹當前節點值大於左子樹所有的鍵值，小於右子樹所有的鍵值.
 中序遍歷可用來做表達式樹(expression tree)及算術表達式樹，如編譯器的基本加減乘除.
 表达式求值也可以使用后缀表达式。后缀表达式求值比中缀表达式更方便，可以先把
 中缀表达式变成后缀表达式，然后再根据后缀表达式求值。
*/

public List<Integer> inorderTraversal(TreeNode root)
{
    List<Integer> res = new ArrayList<>();
    dfs(root, res);
    return res;
}

public void dfs(TreeNode root, List<Integer> res)
{
    if(root==null) return;
    dfs(root.left);
    res.add(root.val);
    dfs(root.right);
}

