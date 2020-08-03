/*
Reverse a singly linked list.
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
*/
    public ListNode reverseList(ListNode head) 
    {
        
        //  (head)->5->4->3->2->1->NULL
        ListNode dummy = new ListNode(0);        
        ListNode cur = head;
    
        //  (cur,head,5)->4->3->2->1->NULL
        //  (dummy,0)->NULL
        
        while(cur!=null)
        {
            ListNode temp = cur; // (temp,cur,head,5)->4->3->2->1->NULL            
            cur = cur.next;      // (temp,head,5)->(cur,4)->3->2->1->NULL
            temp.next = dummy.next; // (temp,head,5)->NULL
            dummy.next = temp;   // (dummy,0)->(temp,head,5)->NULL
        }
        
        return dummy.next;
    }

//without dummy node
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        
        while(head != null)
        {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
    }