package belski.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle_141 {

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) {
                return true;
            }

            set.add(head);
            head = head.next;

        }

        return false;
    }

    public static boolean hasCycleV2(ListNode head) {
        ListNode slowPointer = getPointer(head);
        ListNode fastPointer = getPointer(getPointer(head));

        if (slowPointer == null) {
            return false;
        }

        while (fastPointer != null && fastPointer.next != null) {
            if (slowPointer == fastPointer) {
                return true;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return false;
    }

    public static ListNode getPointer(ListNode head) {
        if (head == null) {
            return null;
        }
        return head.next;
    }

    public boolean hasCycleV3(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int x) {
            val = x;
            next = null;
        }

        ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
        }

        public static ListNode populateListNode(int[] arr) {
            ListNode head = null;

            for (final int j : arr) {
                head = buildHead(head, j);
            }

            // head.next.next.next.next = head.next;
            return head;

        }

        public static ListNode buildHead(ListNode head, int val) {
            if (head == null) {

                head = new ListNode(val);
                return head;
            }
            head.next = buildHead(head.next, val);
            return head;
        }

//           if (head != null) {
//               ListNode newHeadNext = readListNodesInReverseOrder(head.next);
//               ListNode newHead = new ListNode(head.val, newHeadNext);
//
//
//            return newHead;
//           }
//            return null;
//        }
    }

    public static void main(String[] args) {
       ListNode listNode_1 = ListNode.populateListNode(new int[]{5,4,3,2});
    }

}
