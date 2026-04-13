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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;
        ListNode dummy = new ListNode(0,head);
        ListNode prevNode = dummy;
        ListNode temp = head;

        for(int i = 0; i < left-1 ; i++){
            prevNode = temp;
            temp = temp.next;
        }

        ListNode tem = temp;
        ListNode prev = null;

        for(int i = 0; i < right-left+1 ; i++){
            ListNode front = tem.next;
            tem.next = prev;
            prev = tem;
            tem = front;
        }
        //ListNode rp =tem.next;
        prevNode.next = prev;
        temp.next = tem;


        return head;
    }
}