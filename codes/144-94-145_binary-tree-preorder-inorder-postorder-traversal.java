
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

// http://www.google.com
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

// @@@SEPERATOR
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
