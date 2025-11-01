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
    public ListNode modifiedList(int[] nums, ListNode head) {
        // efficient way 
        int max = Arrays.stream(nums).max().getAsInt();
        int[] freq = new int[max + 1];
        for(int num: nums) freq[num]++;

        while(head != null && head.val <= max && freq[head.val] > 0){
            head = head.next;
        }

        if(head == null) return head;

        ListNode previous = head; ListNode current = previous.next;

        while(current != null){
            if(current.val <= max && freq[current.val] > 0){
                // delete this node
                previous.next = current.next;
                current = current.next;
            } else {
                previous = current; current = current.next;
            }
        }

        return head;
    }
}