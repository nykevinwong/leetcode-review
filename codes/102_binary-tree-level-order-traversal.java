import java.util.List;

/*
 無限大樹無法使用dfs. dfs將無限地往下搜尋第一個或某路徑，而用光記憶體而出錯.
 無限大樹可用bfs一層一層搜，但必須有一個bounded branching factor限制最大範圍.
 
 深度為2的樹，無限多孩，二grand child樹。
 這種樹可用dfs，因為一個樹根節支只有兩層，但無法使用bfs，因無一層就無限多孩。

*/
//Recursive approach.
   public  List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(root, res, 0);
        return res;
    }
    
    public void levelOrder(TreeNode root, List<List<Integer>> res, int level) {
        if(root==null) return;
        if(res.size()==level) res.add(new ArrayList<Integer>());
        
        res.get(level).add(root.val);

        levelOrder(root.left, res, level+1);
        levelOrder(root.right, res, level+1);
    }

// iterative approach
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        if(root!=null) q.offer(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode node = q.poll();
                l.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            
            res.add(l);
        }
        return res;
    }