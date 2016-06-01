/**
 * Created by shixu on 2016-05-13.
 */
/**
 * 你有两个用链表代表的整数，
 * 其中每个节点包含一个数字。
 * 数字存储按照在原来整数中相反的顺序
 * ，使得第一个数字位于链表的开头。
 * 写出一个函数将两个整数相加，
 * 用链表形式返回和。
 * */
public class Solution2 {

        public static void main(String[] args) {
            ListNode node1 = new ListNode(1);
            ListNode node2 = new ListNode(5);
            node1.next = node2;

            ListNode node3 = new ListNode(9);
            ListNode node4 = new ListNode(8);
           // ListNode node5 = new ListNode(5);
            node3.next = node4;
           // node4.next = node5;
            ListNode a = new ListNode(3);
            a.next = node1;
            ListNode b = new ListNode(5);
            b.next = node3;

            ListNode result =new Solution2().addLists(a,b);
            while (result.next != null){
                System.out.print(result.val);
                result =result.next;
            }
            System.out.print(result.val);
        }
    public  ListNode addLists(ListNode l1, ListNode l2) {
        int sum =0;
        int carry = 0;
        ListNode result = new ListNode(0);
        while (l1 != null && l2 != null){
            sum = carry+ l1.val+l2.val;
            if (sum > 9){
                listAdd(result,new ListNode(sum % 10));
                carry = 1;
            }
            else{
                listAdd(result, new ListNode(sum));
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1!= null){
            sum = carry+ l1.val;
            if (sum > 9){
                listAdd(result,new ListNode(sum % 10));
                carry = 1;
            }
            else{
                listAdd(result, new ListNode(sum));
                carry = 0;
            }
            l1 = l1.next;
        }
        while (l2!= null){
            sum = carry+ l2.val;
            if (sum > 9){
                listAdd(result,new ListNode(sum % 10));
                carry = 1;
            }
            else{
                listAdd(result, new ListNode(sum));
                carry = 0;
            }
            l2 = l2.next;
        }
        if (carry == 1)
            listAdd(result, new ListNode(carry));
        return result.next;
    }
    public void listAdd(ListNode head, ListNode node){
        ListNode temp = head;
        while(temp.next!= null)
            temp = temp.next;
        temp.next = node;
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

