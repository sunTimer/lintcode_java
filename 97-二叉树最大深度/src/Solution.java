/**
 * Created by shixu on 2016-05-17.
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.left.right.left = new TreeNode(5);
        tree.right.left= new TreeNode(2);
        Solution test = new Solution();
        System.out.println("max depth:"+test.maxDepth(tree));
        System.out.println("min depth:"+test.minDepth(tree));
    }

    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if (root == null)
            return 0;
        int leftMax = maxDepth(root.left)+1;
        int rightMax = maxDepth(root.right)+1;
        return Math.max(leftMax,rightMax);
    }


    public int minDepth(TreeNode root) {
        // write your code here

        if (root == null)
            return 0;
        int leftMin = 0;
        int rightMin = 0;

        if (root.left!= null && root.right != null)
        {
            leftMin = minDepth(root.left)+1;
            rightMin = minDepth(root.right)+1;
        }
        else if (root.left!= null){
            rightMin = minDepth(root.left)+1;
        }
        else if (root.right!= null){
            leftMin = minDepth(root.right)+1;
        }else{
            return 0;
        }
       return Math.min(leftMin,rightMin);
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
