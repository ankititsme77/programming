/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        List<Integer> nodeArrayList = new ArrayList<Integer>();

        while(head != null){

            nodeArrayList.add(head.val);
            head = head.next;

        }

        nodeArrayList.remove(nodeArrayList.size()-n);

        ListNode res = new ListNode(-1);

        ListNode current = res;

        for(Integer element : nodeArrayList){

            current.next  = new ListNode(element);
            current = current.next;

        }

        return res.next;


    }
}