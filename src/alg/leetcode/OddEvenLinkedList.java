package alg.leetcode;

/**
 * Created by feng on 2016/10/27.
 */
public class OddEvenLinkedList {

    public static void main(String[] args) {


        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        ListNode listNode = oddEvenLinkedList.reverseBetween(oddEvenLinkedList.buildList(), 0, 8);

        while (listNode != null) {
            System.out.printf(listNode.val + "\t");
            listNode = listNode.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || n < m) {
            return head;
        }

        int count = 0;
        ListNode p = head, p1 = head.next, pre = null;
        while (p1 != null) {
            count++;
            if (count < m) {
                pre = p;
                p = p1;
                p1 = p1.next;
                continue;
            }
            if (count > n) break;

            ListNode tmp = p1.next;
            p1.next = p;
            p = p1;
            p1 = tmp;
        }

        if (pre != null){
            ListNode tmp = pre.next;
            pre.next = p;
            if (p1 != null){
                tmp.next = p1;
            }else {
                tmp.next = null;
            }
        }else {
            head.next = null;
            return p;
        }

        return head;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode pA = headA, pB = headB;
        //构造环
        while(pA.next != null)pA = pA.next;
        pA.next = headB;
        pA = headA;
        ListNode slow = headB, fast = headB.next.next;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                slow = headA;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
            }
        }
        return pA;
    }

    private ListNode buildList() {
        int[] nums = new int[]{2, 3, 4, 5, 6, 7, 8};
        ListNode head = new ListNode(1);
        ListNode p = head;
        int i = 0;
        while (i < nums.length) {
            ListNode tmp = new ListNode(nums[i]);
            p.next = tmp;
            p = tmp;
            i++;
        }

        p.next = null;

        return head;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = head, evenHead = head.next;
        ListNode p = evenHead.next;
        int current = 1;
        while (p != null && current < 8) {
            if ((current & 1) == 1) {
                oddHead.next = p;
                oddHead = p;
            } else {
                evenHead.next = p;
                evenHead = p;
            }
            current++;
            p = p.next;
        }
        oddHead.next = head.next;
        return head;
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
