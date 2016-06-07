/**
 * Created by wangzhan on 2016-06-07.
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
//        root.left.left = new TreeNode(3);
//        root.right = new TreeNode(4);
//        root.right.right = new TreeNode(4);
//        root.right.right.left = new TreeNode(4);

        Solution testInstance=  new Solution();
        System.out.println(testInstance.minDepth(root));
    }
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null)
            return 0;
        int nowDepth = 1;
        if (root.left == null)
            return computerDepth(root.right,nowDepth);
        if (root.right == null)
            return computerDepth(root.left,nowDepth);
        int left = computerDepth(root.left,nowDepth);
        int right = computerDepth(root.right,nowDepth);
        return Math.min(left,right);
    }
    public int computerDepth(TreeNode root,int nowDepth){
        if (root == null)
            return nowDepth;
        else{
            if (root.left == null &&  root.right == null)
                return nowDepth+1;
            else if(root.left == null){
                nowDepth++;
                return computerDepth(root.right,nowDepth);
            } else if (root.right == null){
                nowDepth++;
                return computerDepth(root.left,nowDepth);
            }else{
                nowDepth++;
                return Math.min(computerDepth(root.left,nowDepth),computerDepth(root.right,nowDepth));
            }
        }
    }
}


class TreeNode{
    int val;
    TreeNode left,right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}