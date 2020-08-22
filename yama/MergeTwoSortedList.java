/*  @@DESCRIPTION
Merge Two Sorted LinkedList. 合併兩個有序鍊接表.
*/
class MergeTwoSortedList implements IInterviewQuestion
{  //使用合併排序法(Merged sort)的合併方法
    public Node mergeTwoLists(Node l1, Node l2) {
        Node dummy = new Node(0);//需要一個標兵，假的資料，方便傳回鍊頭.
        Node temp = dummy;//該標兵同時也是一個新鍊表頭，用來存方合併後的資料.
        // 兩鍊表都還有元素沒遍歷過
        while(l1 !=null && l2 != null)
        {  // 取兩鍊表當前較小的節點
            Node smaller = (l1.val < l2.val) ? l1:l2;
            temp.next = smaller; // 加到新鍊表尾           
            temp = temp.next; // 新鍊表當前頭下移至尾，好連接下筆新資料.
            // 兩鍊表當前較小的節點，己被取出。必須移動該鍊表當前頭，好讀取下筆資料.
            if(l1.val < l2.val) l1=l1.next;
            else l2 = l2.next;
        }
        //只有一鍊表還有資料沒遍歷完，將所有資料一一連接到新鍊表尾部.
        while(l1!=null) 
        {
            temp.next = l1;  // 加到新鍊表尾  
            temp = temp.next; // 新鍊表當前頭下移至尾，好連接下筆新資料.
            l1 = l1.next; // 必須移動該鍊表當前頭，好讀取下筆資料.
        }
        // 同上，但處理另一個可能性.
        while(l2!=null)
        {
            temp.next = l2; // 加到新鍊表尾  
            temp = temp.next; // 新鍊表當前頭下移至尾，好連接下筆新資料.
            l2 = l2.next; // 必須移動該鍊表當前頭，好讀取下筆資料.
        }
        //標邱的用途來了，直接傳回正確的新鍊頭.
        return dummy.next;
    }

    public void performTest()
    {        
         System.out.println("Same contents? " + mergeTwoLists(new Node(new int[] {1,3,6,8}), new Node(new int[]{2,4,5,7}) )
         .equalList(new Node(new int[] {1,2,3,4,5,6,7,8} ) ) );

    }
    
    public String toString() { return "Merge Two Sorted Lists ([N]**) [https://leetcode.com/problems/merge-two-sorted-lists/] ";}

}