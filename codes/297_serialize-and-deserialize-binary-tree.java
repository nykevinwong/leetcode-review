public String serialize(TreeNode root) {
    if(root==null) return "";
    Queue<TreeNode> q= new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    
    if(root!=null) q.offer(root);
    
    while(!q.isEmpty())
    {
        TreeNode node = q.poll();
        
        if(node==null) 
        {
            sb.append("null,");
        }
        else
        {
            sb.append(node.val + ",");
            q.offer(node.left);
            q.offer(node.right);
        }
    }

    sb.deleteCharAt(sb.length()-1);
    return sb.toString();
}
 
// Decodes your encoded data to tree.
public TreeNode deserialize(String data) {
    if(data=="") return null;
    String[] arr = data.split(",");
    
    TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
    Queue<TreeNode> q= new LinkedList<>();
    
    q.offer(root);
    
    for(int i=1; i < arr.length;i++)
    {
        TreeNode node = q.poll();
        
        node.left = (arr[i].equals("null")) ? null: new TreeNode(Integer.parseInt(arr[i]));
        i++;
        node.right = (arr[i].equals("null")) ? null: new TreeNode(Integer.parseInt(arr[i]));
        if(node.left!=null) q.offer(node.left);
        if(node.right!=null) q.offer(node.right);
    }
    
    return root;
}