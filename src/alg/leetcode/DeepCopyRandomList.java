package alg.leetcode;

/**
 * Created by feng on 2016/10/31.
 */
public class DeepCopyRandomList {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        RandomListNode p = head, follow = head.next;
        //新建一个节点并插入到当前节点的后面
        while (p != null) {
            p.next = new RandomListNode(p.label);
            p.next.next = follow;
            p = follow;
            follow = p.next;
        }
        p = head;
        follow = head.next;
        while (p != null) {
            follow.random = p.random == null ? null : p.random.next;
            p = follow.next;
            follow = p == null ? null : p.next;
        }
        RandomListNode h = head.next;
        //恢复及得到新的链表
        p = head;
        follow = head.next;
        while (p != null && follow != null) {
            RandomListNode tmp = follow.next;
            p.next = follow.next;
            p = follow.next;
            follow.next = p.next;
            follow = p.next;
        }
        return h;

    }

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    ;
}
