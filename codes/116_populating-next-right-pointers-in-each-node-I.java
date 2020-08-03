/*空間 complexity 為 O(1) 的解法

選定二元樹的向右指標
填二元樹右Next

左節點層序Next指標遍歷: 
*/
    public Node connect(Node root) {
        if (root==null) return null;
        
        Node leftMost = root, node = null;
        
        while (leftMost.left!=null) {
            node = leftMost;
            while (node!=null) {
                node.left.next = node.right;
                if (node.next!= null) node.right.next = node.next.left;
                node = node.next;
            }
            // go to beginning node of next level
            leftMost = leftMost.left;
        }
        
        return root;         
    }

//暴力解: BFS 層序遍歷

    public Node connect(Node root) {
        if (root==null) return null;
        
        Queue<Node> q = new LinkedList<>();
        
        if(root!=null) q.offer(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            Node prev = null;
            for(int i=0;i<size;i++)
            {
                Node node = q.poll();                
                if(prev!=null) prev.next = node;                
                prev = node;
                
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }                        
        }
        return root;
    }
