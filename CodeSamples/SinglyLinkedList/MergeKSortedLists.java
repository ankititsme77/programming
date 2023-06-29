package CodeSamples.SinglyLinkedList;

 // Definition for singly-linked list.

import java.util.PriorityQueue;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0)
            return new ListNode(-1);

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>((a, b)-> a.val-b.val);

        ListNode res = new ListNode(-1);

        ListNode tail = res;


        for(ListNode listNode : lists){

            if(listNode != null)
                queue.add(listNode);
        }

        while(!queue.isEmpty()){
            tail.next = queue.poll();
            tail = tail.next;

            if(tail.next != null)
                queue.add(tail.next);

        }

        return res.next;

    }
}
