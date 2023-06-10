/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        Set<ListNode> listSet = new HashSet<ListNode>();


        while(head != null){

            if(listSet.contains(head))
                return true;

            else{

                listSet.add(head);
                head = head.next;
            }


        }


        return false;

    }
}