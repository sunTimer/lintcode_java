import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangzhan on 2016-05-31.
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution instance = new Solution();
        System.out.println(instance.binaryTreePaths(root));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> pathList = new ArrayList<>();
        if (root == null)
            return pathList;
        String path = "";
        childPaths(pathList, root, path);
        return pathList;
    }

    private void childPaths(ArrayList<String> pathList, TreeNode root, String path) {
        if (root == null)
            return;
        path += root.val;
        if (root.left == null && root.right == null) {
            pathList.add(path);
            return;
        } else {
            childPaths(pathList, root.left, path+"->");
            childPaths(pathList, root.right, path+"->");
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
