import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangzhan on 2016-05-29.
 */
public class Solution {
    public static void main(String[] args) {
        Solution instance = new Solution();
        int[] inorder = {8, 4, 2, 5, 1, 6, 3, 7};
        int[] postorder = {8, 4, 5, 2, 6, 7, 3, 1};
        System.out.println(instance.serialize(instance.buildTree(inorder, postorder)));
    }

    /**
     * @param inorder   : A list of integers that inorder traversal of a tree
     * @param postorder : A list of integers that postorder traversal of a tree
     * @return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int ileft = 0;
        int iright = inorder.length - 1;
        int pleft = ileft;
        int pright = iright;

        return buildReg(inorder, postorder, ileft, iright, pleft, pright);

    }

    private TreeNode buildReg(int[] inorder, int[] postorder, int ileft, int iright, int pleft, int pright) {
        if (ileft > iright || pleft > pright)
            return null;
        int nodeVal = postorder[pright];
        int index = getPosition(inorder, nodeVal);
        TreeNode root = new TreeNode(nodeVal);
        root.left = buildReg(inorder, postorder, ileft, index - 1, pleft, pright - iright + index - 1);
        root.right = buildReg(inorder, postorder, index + 1, iright, pright - iright + index, pright - 1);
        return root;
    }
    private int getPosition(int[] inorder, int nodeVal) {
        int position = 0;
        for (int value : inorder) {
            if (nodeVal == inorder[position])
                break;
            position++;
        }
        return position;
    }

    public String serialize(TreeNode root) {
        // write your code here
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder data = new StringBuilder();
        int childSize = 0;
        int parentSize = 1;

        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()) {
            if (parentSize == 0 && childSize == 0)
                break;
            TreeNode node = queue.poll();
            if (node != null)
                data.append(node.val + ",");
            else {
                data.append("#,");
                continue;
            }
            parentSize--;
            if (node.left != null) {
                queue.add(node.left);
                childSize++;
            } else {
                queue.add(null);
            }
            if (node.right != null) {
                queue.add(node.right);
                childSize++;
            } else {
                queue.add(null);
            }
            System.out.print(node.val + " ");
            if (parentSize == 0) {
                System.out.println();
                parentSize = childSize;
                childSize = 0;
            }
        }
        return data.toString();
    }




}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
