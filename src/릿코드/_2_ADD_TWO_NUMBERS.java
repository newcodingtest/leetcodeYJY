/*
package 릿코드;
*/
/*
Input: l1 = [2,4,3], l2 = [5,6,4]
        Output: [7,0,8]
        Explanation: 342 + 465 = 807.

*//*

public class _2_ADD_TWO_NUMBERS {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode p;
        ListNode dummy = new ListNode(0);
        p = dummy;
          while(l1 != null || l2 !=null || carry != 0){
                if(l1 != null){
                    carry += l1.val;
                    l1 = l1.next;
                }
                if(l2 != null){
                    carry += l2.val;
                    l2 = l2.next;
                }
                p.next = new ListNode(carry%10);
                carry /= 10;
                p = p.next;
          }
          return dummy.next;
    }

    public static void main(String[] args){
          int[] first = {2,4,3};
          int[] second = {5,6,4};

        System.out.println(addTwoNumbers(first,second));
    }

}
*/
