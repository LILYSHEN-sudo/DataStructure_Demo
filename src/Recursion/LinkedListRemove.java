package Recursion;

public class LinkedListRemove<E> {
    //Method-1
    public ListNode removeElements1(ListNode head, int val) {
        while(head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if(head == null) {
            return head;
        }

        ListNode prev = head;
        while(prev.next != null) {
            if(prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    //Method-2
    public ListNode removeElements2(ListNode head, int val) {
        while(head != null && head.val == val) {
            head = head.next;
        }
        if(head == null) {
            return head;
        }
        ListNode prev = head;
        while(prev.next != null) {
            if(prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    //Method-3
    public ListNode removeElements3(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while(prev.next != null) {
            if(prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    //Method-4
    public ListNode removeElements4(ListNode head, int val) {
        if(head == null) {
            return head;
        }
        ListNode res = removeElements4(head.next, val);
        if(head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }

    //Method-5
    public ListNode removeElements5(ListNode head, int val) {
        if(head == null) {
            return head;
        }
        head.next = removeElements5(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        LinkedListRemove link = new LinkedListRemove();
        ListNode res = link.removeElements5(head, 3);
        System.out.println(res);
    }
}
