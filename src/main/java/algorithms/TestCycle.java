package algorithms;

public class TestCycle {

    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode ptr2 = findCycle(head);
        if(ptr2 == null) {
            return null;
        }

        ListNode ptr1 = head;
        while(ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;

    }

    private ListNode findCycle(ListNode head) {
         ListNode tortoise = head;
         ListNode hare = head;
         while (hare != null && hare.next != null) {
             tortoise = tortoise.next;
             hare = hare.next.next;
             if (tortoise == hare) {
                 return tortoise;
             }
         }
         return null;

//        ListNode slow = head;...妈的这里原来是+1，但是这样就用不了那个公式了
//        ListNode fast = head;...然后机智的改成不+1，但是这样后面循环就不能那么写，要不直接跳出循环
//        while(slow != fast) {   妈的，太蠢了
//            if(fast == null || fast.next == null) {
//                return null;
//            }
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        TestCycle tc = new TestCycle();
        ListNode res = tc.detectCycle(n1);
        System.out.println(res.val);
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}