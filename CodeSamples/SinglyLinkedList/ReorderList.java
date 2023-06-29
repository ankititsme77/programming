package CodeSamples.SinglyLinkedList;

/**
 *
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 */
public class ReorderList {

    public void reorderList(ListNode head) {

        if (head == null) return;

        ListNode slow = head;

        ListNode fast = head;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode prev = null;
        ListNode current = slow;

        while(current != null){

            ListNode tmp = current.next;
            current.next = prev;
            prev= current;
            current = tmp;

        }

        ListNode first = head;
        ListNode second = prev;

        while(second.next != null){

            ListNode tmp = first.next;
            first.next = second;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;


        }

    }
}
