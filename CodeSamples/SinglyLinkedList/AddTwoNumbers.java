/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 ==null) return l2;

        if(l2 ==null) return l1;

        if(l1 ==null && l2 ==null) new ListNode(-1);


        ListNode result = new ListNode(0);

        ListNode current = result;

        int carry =0;

        while(l1 !=null || l2 !=null || carry > 0 ){

            int x = l1!=null?l1.val:0;
            int y = l2!=null?l2.val:0;
            int sum  = x+y+carry ;
            carry = sum /10;
            int res = sum %10;

            current.next = new ListNode(res);
            current  = current.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return result.next;

    }
}