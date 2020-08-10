public static Node connect(Node root) {            
    Node nextHead = new Node(0);
    nextHead.next = root;
    
    while(nextHead.next != null)
    {
        Node tail = nextHead;
        Node n = nextHead.next;
        nextHead.next = null;
        
        for(; n != null; n = n.next){
            if(n.left != null){
                tail.next = n.left;
                tail = tail.next;
            }
            
            if(n.right != null){
                tail.next = n.right; 
                tail = tail.next;
            }
        }
    }
    
    return root;   
}