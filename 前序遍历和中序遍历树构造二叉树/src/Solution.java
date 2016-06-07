import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangzhan on 2016-05-29.
 */
public class Solution {
    public static void main(String[] args) {
        Solution instance = new Solution();
        int[] inorder = {4,1,5,2,6,3,7};
        int[] preorder = {2,1,4,5,3,6,7};
        System.out.println(instance.serialize(instance.buildTree(preorder, inorder)));
    }

    /**
     * @param preorder : A list of integers that preorder traversal of a tree
     * @param inorder  : A list of integers that inorder traversal of a tree
     * @return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        int ileft = 0;
        int iright = inorder.length - 1;
        int pleft = ileft;
        ;
        int pright = iright;
        return build(preorder, inorder, ileft, iright, pleft, pright);
    }

    private TreeNode build(int[] preorder, int[] inorder, int ileft, int iright, int pleft, int pright) {
        if (ileft > iright || pleft > pright)
            return null;
        int childTreeRootNodeVal = preorder[pleft];
        int indexInInorder = getPosition(inorder, childTreeRootNodeVal);
        TreeNode root = new TreeNode(childTreeRootNodeVal);
        root.left = build(preorder, inorder, ileft, indexInInorder - 1, pleft + 1, indexInInorder - ileft + pleft);
        root.right = build(preorder, inorder, indexInInorder + 1, iright, indexInInorder - ileft + pleft + 1, pright);
        return root;
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


    private int getPosition(int[] inorder, int nodeVal) {
        int position = 0;
        for (int value : inorder) {
            if (nodeVal == inorder[position])
                break;
            position++;
        }
        return position;
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
