import java.util.ArrayList;

/**
 * Created by shixu on 2016-05-21.
 */
public class Solution2 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(4);

        TreeNode t2 = new TreeNode(3);
        t2.right = new TreeNode(4);
        //t2.right.left = new TreeNode(5);


        Solution2 test = new Solution2();
        System.out.println(test.isSubtree(tree, t2));
    }


    /**
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        ArrayList t1_list = new ArrayList();
        ArrayList t2_list = new ArrayList();
        t1_list = order(T1,t1_list);
        t2_list = order(T2,t2_list);

        if (t1_list.toString().contains(t2_list.toString())) {
            return true;
        }

        return false;
    }

    private ArrayList order(TreeNode t, ArrayList orderList) {
        if (t == null)
            return orderList;
        if (t.left != null) {
            order(t.left.left, orderList);
            orderList.add(t.left.val);
            order(t.left.right, orderList);
        }
        orderList.add(t.val);
        if (t.right != null) {
            order(t.right.left, orderList);
            orderList.add(t.right.val);
            order(t.right.right, orderList);
        }
        return orderList;
    }
}
