import java.util.ArrayList;

/**
 * Created by shixu on 2016-05-21.
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(4);

        TreeNode t2 = new TreeNode(3);
        t2.right = new TreeNode(4);
        //t2.right.left = new TreeNode(5);


        Solution test = new Solution();
        System.out.println(test.isSubtree(tree, t2));
    }


    /**
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
      /*  ArrayList t1_list = new ArrayList();
        ArrayList t2_list = new ArrayList();
        t1_list = order(T1,t1_list);
        t2_list = order(T2,t2_list);


        if (!t1_list.retainAll(t2_list)) {
            return false;
        }*/
        StringBuilder orderT1 = new StringBuilder();
        StringBuilder orderT2 = new StringBuilder();
        orderT1 = order(T1,orderT1);
        orderT2 = order(T2,orderT2);
        if (orderT1.toString().contains(orderT2.toString()))
            return true;
        return false;
    }

    private StringBuilder order(TreeNode t, StringBuilder orderStr) {
        if (t == null)
            return orderStr;
        if (t.left != null) {
            order(t.left.left, orderStr);
            orderStr.append(t.left.val);
            order(t.left.right, orderStr);
        }
        orderStr.append(t.val);
        if (t.right != null) {
            order(t.right.left, orderStr);
            orderStr.append(t.right.val);
            order(t.right.right, orderStr);
        }
        return orderStr;
    }
}

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }

}