/**
 * Created by wangzhan on 2016-06-01.
 */
public class Solution {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        Solution instance = new Solution();
        instance.sortedArrayToBST(a);
    }

    public TreeNode sortedArrayToBST(int[] A) {
        // write your code here
        if (A.length == 0)
            return null;
        int left = 0;
        int right = A.length-1;
        TreeNode root = new TreeNode(A[right/2]);
        buildTree(root,A,left,right/2-1 ,0);
        buildTree(root,A,right/2+1,right,1);
        return root;
    }

    private void buildTree(TreeNode root, int[] a, int left, int right, int flag) {
        if (left > right)
            return;
        if (flag == 0){
            root.left = new TreeNode(a[(left+right)/2]);
            buildTree(root.left,a,left,(left+right)/2-1,0);
            buildTree(root.left,a,(left+right)/2+1,right,1);
        }else
        {
            root.right = new TreeNode(a[(left+right)/2]);
            buildTree(root.right,a,left,(left+right)/2-1,0);
            buildTree(root.right,a,(left+right)/2+1,right,1);
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
