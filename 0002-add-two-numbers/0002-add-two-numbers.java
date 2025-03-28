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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode();
        ListNode answer = tmp;
        int div = 0;
        while(l1!=null || l2!=null){
            int sum = div;
            if (l1!=null){
                sum+=l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                sum+=l2.val;
                l2 = l2.next;
            }
            div = sum/10;
            sum%=10;

            tmp.next = new ListNode(sum);
            tmp = tmp.next;
        }

        if (div>0){
            tmp.next = new ListNode(div);
        }

        return answer.next;
    }
}