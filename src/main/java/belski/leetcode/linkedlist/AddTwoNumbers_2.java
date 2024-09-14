package belski.leetcode.linkedlist;

public class AddTwoNumbers_2 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public static ListNode populateListNode(int[] arr) {
            ListNode head = null;

            for (final int j : arr) {
                head = buildListNode(head, j);
            }

            // head.next.next.next.next = head.next;
            return head;

        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int decimalPart = 0;
        ListNode reversed = null;
        while (l1 !=null || l2 != null) {
            int val_1 = l1 == null ? 0 : l1.val;
            int val_2 = l2 == null ? 0 : l2.val;

            int sum = val_1 + val_2 + decimalPart;
            int digit = sum % 10;
            decimalPart = sum / 10;

            reversed = buildListNode(reversed, digit);

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return decimalPart == 1 ? buildListNode(reversed, 1) : reversed;
    }

    public static ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }

    public static ListNode buildListNode(ListNode head, int val) {
        if (head == null) {

            head = new ListNode(val);
            return head;
        }
        head.next = buildListNode(head.next, val);
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.populateListNode(new int[]{5,3,4,9});
        ListNode l2 = ListNode.populateListNode(new int[]{7,8,9});

       ListNode reversed =  AddTwoNumbers_2.addTwoNumbersV2(l1, l2);
    }

}
