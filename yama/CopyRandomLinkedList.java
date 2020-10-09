import java.util.HashMap;

/*  @@DESCRIPTION
Copy Random LinkedList. 拷貝帶有指向其它節點的鍊接表.
*/

public class CopyRandomLinkedList  implements IInterviewQuestion {
    // Dummy 節點複製有random節點的鍊表解法
    // 一個來源鍊表.一個哈希表存舊新節點對照表。一個零值dummy node.
    // 用兩指標分別同時遍歷來源鍊表及當前新鍊表.
    // 第一次遍歷時，將當前新鍊表下個設成新複製的對應節點，並存入舊新節點對照表。
    // 第二次遍歷時，用舊新節點對照表找出新節點的random所該對應的節點.
    // 新鍊表頭就是最初的dummy.next.

    // 不用 Dummy 節點複製有random節點的鍊表解法
    // 一個來源鍊表.一個哈希表存舊新節點對照表。不用Dummy node.
    // 用一指標分別遍歷來源鍊表.
    // 第一次遍歷時，直接存當前舊節點對照新複製對應節點的表。
    // 第二次遍歷時，用對照表由當前舊節點取出新複製對應節點，並將新節點next設成，當前舊節點的next.
    // 同時，用對照表由當前舊節點的random取出新複製對應節點，將此新節點設成當前新節點的random.
    // 新鍊表頭就是由舊鍊表頭對應新鍊表頭的位置. 
 
    public Node copyRandomListWithDummyNode(Node head)   {
        if(head==null) return null;        
        HashMap<Node, Node> m = new HashMap<Node, Node>(); // 舊鍊表指標對映到新鍊表指標
        Node dummy = new Node(0); // 使用dummy，簡化程式碼
        
        // 迴圈遍歷整個舊鍊表, 同時建立新指標及遍歷新鍊表
        for(Node cur = head, temp = dummy; cur!=null; cur=cur.next, temp=temp.next)
        { 
            temp.next = new Node(cur.val); // 建立新指鏢
            m.put(cur, temp.next); 
        }
                
        // 迴圈遍歷整個舊新鍊表，將舊鍊表指鏢對映的位置存入新鍊表的random指鏢
        for(Node cur = head, temp = dummy.next; cur!=null; cur=cur.next, temp=temp.next)
        {
            if(cur.random!=null) temp.random = m.get(cur.random); //存對應的random
        }
        
        return dummy.next; // 傳回新鍊表的頭
    }

    public Node copyRandomListWithoutDummyNode(Node head)   {
        if(head==null) return null;        
        HashMap<Node, Node> m = new HashMap<Node, Node>();

        // 遍歷整個已有鍊表，直接存舊鍊表指標對映到新鍊表指標
        for(Node cur = head; cur!=null; cur=cur.next)
        {
            m.put(cur, new Node(cur.val));// 存新建立的指標
        }

        // 再遍歷整個已有鍊表，直接取出新鍊表指標，然後同時設定對應的next及random.  
        for(Node cur = head; cur!=null; cur=cur.next)
        {
            m.get(cur).next = m.get(cur.next); //存對應的next
            m.get(cur).random = m.get(cur.random);//存對應的random
        }

        return m.get(head);
    }


    public void performTest()
    {
        Node root = new Node(new int[] {0,1,2,3,4,5,6,7,8,9}, new int[] {0 ,1,3,5,7,9,0,6, 8,0});
        Node copy = new Node(new int[] {0,1,2,3,4,5,6,7,8,9}, new int[] {0 ,1,3,5,7,9,0,6, 8,0});
        System.out.println("Same contents? " + copyRandomListWithDummyNode(root ).equalList(copy) );
        System.out.println("Same contents? " + copyRandomListWithoutDummyNode(root ).equalList(copy) );

    }
    
    public String toString() { return "Copy Random Linked List ([N]**) [https://leetcode.com/problems/reorganize-string/] ";}
}