package alg.leetcode;

/**
 * Created by feng on 2016/10/31.
 */
public class ReverseKList {

    public static void main(String[] args) {
        ReverseKList reverseKList = new ReverseKList();
        ListNode tm = reverseKList.reverseKGroup(reverseKList.buildList(), 1);
        reverseKList.printList(tm);

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head, tail = head, tmp = new ListNode(0), res = tmp;
        int count = 0;
        while (p1 != null && tail != null) {
            count++;

            if (count == k) {
                System.out.println("p1.val = " + p1.val + "tailval = " + tail.val);
                ListNode tailNext = tail.next;
                tmp.next = reverseList(p1, tail);
                tmp = p1;
                p1 = tailNext;
                tail = tailNext;
                count = 0;
            } else {
                tail = tail.next;
            }
        }
        if (count < k){
            tmp.next = p1;
        }
        return res.next;
    }

    private ListNode reverseList(ListNode head, ListNode tail) {
        if (head == null || head.next == null || head == tail) return head;
        ListNode p = head.next, prev = head;
        while (prev != tail) {
            ListNode tmp = p.next;
            p.next = prev;
            prev = p;
            p = tmp;
        }

        head.next = null;
        return prev;
    }

    /**
     * 新建链表
     *
     * @return
     */
    private ListNode buildList() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6,7};
        ListNode head = new ListNode(1);
        ListNode p = head;
        int i = 1;
        while (i < nums.length) {
            ListNode tmp = new ListNode(nums[i]);
            p.next = tmp;
            p = tmp;
            i++;
        }

        p.next = null;

        return head;
    }

    private void printList(ListNode node) {
        while (node != null) {
            System.out.printf(node.val + "\t");
            node = node.next;
        }

        System.out.printf("\n");

    }


    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
