package mergeTwoLists;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null && l2==null)
            return null;
        else if(l1==null)
            return l2;
        else if(l2==null)
            return l1;

        ListNode curr = new ListNode(-1);
        ListNode strPtr = curr;

        while (l1 != null || l2 != null) {

            if (l1 == null) {
                curr.val = l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                curr.val = l1.val;
                l1 = l1.next;
            } else if (l1.val <= l2.val) {
                curr.val = l1.val;
                l1 = l1.next;
            } else if (l2.val <= l1.val) {
                curr.val = l2.val;
                l2 = l2.next;
            }

            if(l1 != null || l2 != null){
                ListNode newNode = new ListNode(-1);
                curr.next = newNode;
                curr = curr.next;
            }
        }
        return strPtr;
    }
}