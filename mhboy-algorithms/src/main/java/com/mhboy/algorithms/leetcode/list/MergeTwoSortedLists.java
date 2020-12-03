package com.mhboy.algorithms.leetcode.list;

/**
 * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
 * Example 1:
 * <p>
 * <p>
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 * <p>
 * Input: l1 = [], l2 = []
 * Output: []
 * Example 3:
 * <p>
 * Input: l1 = [], l2 = [0]
 * Output: [0]
 *  
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both l1 and l2 are sorted in non-decreasing order.
 * <p>
 */
public class MergeTwoSortedLists {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            int l1vv = l1.val;
            int l2vv = l2.val;
            ListNode head = null;
            if (l1vv <= l2vv) {
                head = l1;
            } else {
                head = l2;
            }
            ListNode target = new ListNode();
            target.next = head;

            while (l1 != null && l2 != null) {
                int l1v = l1.val;
                int l2v = l2.val;
                if (l1v <= l2v) {
                    ListNode tmp = l1.next;
                    head.next = l1;
                    head = head.next;
                    l1 = tmp;
                } else {
                    ListNode tmp = l2.next;
                    head.next = l2;
                    head = head.next;
                    l2 = tmp;
                }
                if (l1 == null) {
                    head.next = l2;
                } else if (l2 == null) {
                    head.next = l1;
                }
            }
            return target.next;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedLists lists = new MergeTwoSortedLists();

    }
}
