public static Node connect(Node root) {            
    Node nextHead = new Node(0); //用dummy node
    nextHead.next = root; 
    
    while(nextHead.next != null) // 如果根或next不為空
    {
        Node prev = nextHead;
        Node cur = nextHead.next;
        nextHead.next = null;
        
        for(; cur != null; cur = cur.next){
            if(cur.left != null){
                prev.next = cur.left;
                prev = prev.next;
            }
            
            if(cur.right != null){
                prev.next = cur.right; 
                prev = prev.next;
            }
        }
    }
    
    return root;   
}