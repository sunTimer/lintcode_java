
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by wangzhan on 2016-05-30.
 */
public class Solution {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution instance = new Solution();

        TreeNode tree = instance.deserialize("1,2,3,4,#,#,5,#,#,6,7,#,#,#,8");
        System.out.println(instance.zigzagLevelOrder(tree ));
    }
    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include
     *          the zigzag level order traversal of its nodes' values
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> tempStack = new Stack<>();
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root ==  null)
            return resultList;
        stack.push(root);
        int level = 1;
        int childSize = 0;
        int parentSize = 1;
        while (stack!= null){
            TreeNode tempNode;
            tempNode = stack.pop();
            parentSize--;
            System.out.print(tempNode.val+" ");
            if (level % 2 != 0){   //奇数层
                if (tempNode.left!=null) {
                    tempStack.push(tempNode.left);
                    childSize++;
                }
                if (tempNode.right !=null) {
                    tempStack.push(tempNode.right);
                    childSize++;
                }
            }
            else{
                if (tempNode.right !=null) {
                    tempStack.push(tempNode.right);
                    childSize++;
                }
                if (tempNode.left!=null) {
                    tempStack.push(tempNode.left);
                    childSize++;
                }
            }


            list.add(tempNode.val);
            if (parentSize == 0){
                parentSize = childSize;
                childSize= 0;
                System.out.println();
                ArrayList<Integer> tempList = (ArrayList) list.clone();
                resultList.add(tempList);
                list.removeAll(list);
            }
            if (stack.isEmpty()) {
                level++;
                if (tempStack.isEmpty())
                    break;
                stack = (Stack)tempStack.clone();
                tempStack.removeAll(tempStack);
            }
        }
        return resultList;
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
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.right = this.left = null;
    }
}