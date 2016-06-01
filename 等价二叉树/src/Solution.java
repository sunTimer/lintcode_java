
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by wangzhan on 2016-05-30.
 */
public class Solution {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);


        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.right.right = new TreeNode(4);

        Solution instance = new Solution();
        System.out.println(instance.isIdentical(root, tree));

    }

    /**
     * @param a, b, the root of binary trees.
     * @return true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
        // Write your code here

        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;
        else {
            if (a.val == b.val) {
                if (isIdentical(a.left, b.left))
                    return isIdentical(a.right, b.right);
                else
                    return false;
            } else
                return false;
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.right = this.left = null;
    }
}