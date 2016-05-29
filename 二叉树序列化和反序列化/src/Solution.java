import sun.reflect.generics.tree.Tree;

import java.awt.peer.ScrollbarPeer;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangzhan on 2016-05-29.
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(4);

        Solution instance = new Solution();
        String data = instance.serialize(root);
        TreeNode tree = instance.deserialize("1,2,#,3,#,4");
    }

    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
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

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data == null || data.equals(""))
            return null;
        String[] splitVals = data.split(",");
        Queue<String> dataQueue = new LinkedList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        for (int i = 0; i < splitVals.length; i++) {
            dataQueue.add(splitVals[i]);
        }
        TreeNode root = new TreeNode(Integer.parseInt(dataQueue.poll()));
        nodeQueue.add(root);
        while (!dataQueue.isEmpty()) {
            while (!nodeQueue.isEmpty()) {
                if (dataQueue.isEmpty())
                    break;
                TreeNode tempNode = nodeQueue.poll();
                String leftChildVal = dataQueue.poll();
                if (leftChildVal.equals("#"))
                     tempNode.left = null;
                else {
                    TreeNode childNode = new TreeNode(Integer.parseInt(leftChildVal));
                    tempNode.left = childNode;
                    nodeQueue.add(tempNode.left);
                }
                if (dataQueue.isEmpty())
                    break;
                String rightChildVal = dataQueue.poll();
                if (rightChildVal.equals("#"))
                    tempNode.right = null;
                else {
                    TreeNode childNode = new TreeNode(Integer.parseInt(rightChildVal));
                    tempNode.right = childNode;
                    nodeQueue.add(tempNode.right);
                }
            }
        }
        return root;
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
