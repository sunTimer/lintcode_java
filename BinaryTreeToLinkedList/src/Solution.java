import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangzhan on 2016-06-01.
 */
public class Solution {
    public static void main(String[] args) {


        Solution instance = new Solution();
        TreeNode tree = instance.deserialize("98,97,#,88,#,84,#,79,87,64,#,#,#,63,69,62,#,#,#,30,#,27,59,9,#,#,#,3,#,0,#,-4,#,-16,#,-18,-7,-19,#,#,#,-23,#,-34,#,-42,#,-59,#,-63,#,-64,#,-69,#,-75,#,-81");
        System.out.println(instance.serialize(instance.flatten(tree)));
    }

    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public TreeNode flatten(TreeNode root) {
        // write your code here
        if (root == null)
            return null;
        TreeNode p = null;
        TreeNode end = root;
        if (root.left != null) {
            p = root.right;
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
        flatten(p);
        while (end.right != null)
            end = end.right;
        end.right = p;
        //flatten(p);
        return root;



    }


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
            System.out.print(node.val + "--- ");
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
        this.right = this.left = null;
    }
}
