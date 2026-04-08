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
        if(head == null || head.next == null) return null;
        ListNode temp = head;
        int count =0;

        while(temp != null){
            count++;
            temp = temp.next;
        }

        ListNode tem = head;

        if(count-n == 0) return tem.next;


        for(int i=1; i<count-n; i++){
            tem = tem.next;
        }
        tem.next = tem.next.next;
        return head;
    }
}