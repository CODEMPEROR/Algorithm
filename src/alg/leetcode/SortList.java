package alg.leetcode;

/**
 * Created by feng on 2016/10/28.
 */
public class SortList {

    public static void main(String[] args) {
        SortList list = new SortList();
        ListNode node = list.mergeSort(list.buildList());
        list.printList(node);
    }


    /**
     * 插入排序
     *
     * @param head
     * @return
     */
    public ListNode insertSort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev, insert = head.next, p;
        ListNode last;
        while (insert != null) {
            p = head;
            ListNode inext = insert.next;
            prev = null;
            //找到第一个比insert大的节点 p
            while (p != insert && p.val < insert.val) {
                prev = p;
                p = p.next;
            }
            ListNode tmp = head;
            while (tmp.next != insert) tmp = tmp.next;
            last = tmp;
            //insert小于head
            if (prev == null) {
                insert.next = head;
                last.next = inext;
                head = insert;

            } else if (p != insert && p.val > insert.val) {
                prev.next = insert;
                insert.next = p;
                last.next = inext;
            }
            insert = inext;
        }

        return head;
    }


    /**
     * 归并排序
     *
     * @param head
     * @return
     */
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = findMid(head), right = mid.next;
        mid.next = null;

        return merge(mergeSort(head), mergeSort(right));
    }

    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0), p = head;
        while (l1 != null && l2 != null) {
            ListNode tmp = l1.val < l2.val ? l1 : l2;
            p.next = tmp;
            p = tmp;
            if (l1 == tmp) {
                l1 = tmp.next;
            } else {
                l2 = tmp.next;
            }
        }

        if (l1 == null){
            p.next = l2;
        }

        if (l2 == null){
            p.next = l1;
        }

        return head.next;
    }

    /**
     * 找到链表中间元
     * @param head
     * @return
     */
    private ListNode findMid(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    /**
     * 希尔排序
     *
     * @param head
     * @return
     */
    public ListNode shell(ListNode head) {

        return head;
    }


    ///////////////////////////////////////////////////

    /**
     * 快排
     */
    public ListNode partition(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode h = head, t = head.next, mid = null;
        int x = head.val;
        while (t != null) {
            if (h.val >= x) {
                while (t != null && t.val >= x) t = t.next;
                if (t == null) break;
                mid = h;
                exchangeVal(t, h);
            }
            h = h.next;
            t = t.next;
        }
        System.out.printf("x = " + x + "\t");
        printList(head);

        ListNode n = mid == null ? head.next : mid.next;
        if (mid == null) {
            head.next = null;
        } else {
            mid.next = null;
        }
        ListNode left = partition(head);
        ListNode right = partition(n);
        while (left != null && left.next != null) {
            left = left.next;
        }
        if (left == null) return right;
        else left.next = right;

        return head;
    }

    private void exchangeVal(ListNode l1, ListNode l2) {
        if (l1.val == l2.val) return;
        l1.val ^= l2.val;
        l2.val ^= l1.val;
        l1.val ^= l2.val;
    }


    //////////////////////////////////////////////////////

    /**
     * 新建链表
     *
     * @return
     */
    private ListNode buildList() {
        int[] nums = new int[]{6, 3, 2, 5, 6, 7, 1, 8, 9, 4, 10};
        ListNode head = new ListNode(6);
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
