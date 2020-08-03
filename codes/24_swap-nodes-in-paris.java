//Given 1->2->3->4, you should return the list as 2->1->4->3.
//You may not modify the values in the list's nodes, only nodes itself may be changed.
   
  
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;

        //  [first]->[second]->[thrid]

        // 用良好變數名稱.
        ListNode first = head;
        ListNode second = first.next; 

       // 將第一節點next指到第三節點，也就是指到第二節點next
        first.next = second.next;     
        second.next = first;
       

        first.next = swapPairs(first.next); // swap next one
        return second;
    }