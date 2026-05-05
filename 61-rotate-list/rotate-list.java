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
    public ListNode rotateRight(ListNode head, int k) {
        int n = 0;
        if(head == null || k == 0) return head;

        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            n++;
        }

        int idx = n - k % n;
        if(idx == n) return head;

        temp = head; 
        for(int i = 1; i < idx; i++){
            temp = temp.next;
        }

        ListNode rotate = temp.next; temp.next = null;
        ListNode temp2 = rotate;

        while(temp2 != null && temp2.next != null){
            temp2 = temp2.next;
        }

        temp2.next = head; head = rotate;
        return head;

    }
}