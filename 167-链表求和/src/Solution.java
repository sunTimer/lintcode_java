/*
import org.w3c.dom.NodeList;

import java.util.List;
import java.util.Stack;

*/
/**
 * Created by shixu on 2016-05-12.
 *//*

public class Solution {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;

        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node3.next = node4;
        node4.next = node5;
        ListNode a = new ListNode(1);
        a.next = node1;
        ListNode b = new ListNode(2);
        b.next = node3;

        ListNode result = Solution.addLists(a,b);
        while (result.next != null){
            System.out.println(result.val);
            result =result.next;
        }
        System.out.println(result.val);
    }


    */
/**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     *//*

    public static ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        Stack stack3 = new Stack();
        while (l1 != null){
            stack1.push(l1.val);
            if (l1.next != null)
                l1 = l1.next;
            else
                break;
        }
        while (l2 != null){
            stack2.push(l2.val);
            if (l2.next != null)
                l2 = l2.next;
            else
                break;
        }

        ListNode result = new ListNode(0);
        int sum  = 0;
        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            sum = (Integer)stack1.pop()+(Integer)stack2.pop()+ carry;
            if (sum > 9){
                ListNode units = new ListNode(sum % 10);
                carry =1;
                stack3.push(units);
                continue;
            }else{
                carry =0;
                stack3.push(sum);
            }
        }

        while (!stack1.isEmpty()){
            sum = (Integer)stack1.pop()+ carry;
            if (sum > 9){
                ListNode units = new ListNode(sum % 10);
                carry =1;
                stack3.push(units);
                continue;
            }else{
                carry =0;
                stack3.push(sum);
            }
        }

        while (!stack2.isEmpty()){
            sum = (Integer)stack2.pop()+ carry;
            if (sum > 9){
                ListNode units = new ListNode(sum % 10);
                carry =1;
                stack3.push(units);
                continue;
            }else{
                carry =0;
                stack3.push(sum);
            }
        }
        ListNode resultList = new ListNode(0);
        while (!stack3.isEmpty()){
            add(resultList,new ListNode((Integer)stack3.pop()));
        }
        return resultList.next;
    }


    static void add(ListNode head, ListNode data){
        ListNode temp = head;
        while(temp.next != null){
            temp= temp.next;
        }
        temp.next=data;
    }
}

 class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}*/
