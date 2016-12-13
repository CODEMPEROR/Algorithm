package alg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by feng on 2016/10/30.
 */
public class ReorderList {

    public static void main(String[] args) {
        ReorderList list = new ReorderList();
        list.reorderList(list.buildList());
        List<Integer> list1 = new ArrayList<>();
        Arrays.asList(args);
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverse(slow);
        ListNode p = head;

        while (p != slow){
            ListNode next = p.next;
            ListNode sNext = secondHalf.next;
            p.next = secondHalf;
            secondHalf.next = next;
            secondHalf = sNext;
            p = next;
        }

        p.next = null;

        while (head != null){
            System.out.println(head.val + "\t");
            head = head.next;
        }

    }

    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p2 = head.next, p1 = head;

        while(p2 != null){
           ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }
        head.next = null;
        return p1;
    }

    private ListNode buildList() {
        int[] nums = new int[]{1,2,3};
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

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
