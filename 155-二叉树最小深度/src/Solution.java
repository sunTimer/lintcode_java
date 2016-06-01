/**
 * Created by shixu on 2016-05-21.
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.left.right.left = new TreeNode(5);
        tree.right.left = new TreeNode(2);


        Solution test = new Solution();
        System.out.println("min depth:"+test.minDepth(tree));
    }
    public int minDepth(TreeNode root) {
        int leftDep = 0;
        int rightDep = 0;
        if (root == null)
            return 0;
        leftDep = minDepth(root.left)+1;
        rightDep = minDepth(root.right)+1;
        if (leftDep!= 0 && rightDep!=0)
            return Math.min(leftDep,rightDep)+1;
        else
            return Math.max(leftDep,rightDep)+1;
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