
import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

import static javafx.scene.input.KeyCode.Q;

/**
 * Created by shixu on 2016-05-21.
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     * 二叉树层次遍历
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        ArrayList list = new ArrayList();
        Queue queue = new LinkedList();
        queue.add(root);
        int childSize = 0;
        int parentSize = 1;
        TreeNode temp;
        if (root ==null)
            return resultList;
        do {
            temp = (TreeNode)queue.poll();
            System.out.print(temp.val);
            list.add(temp.val);
            if (temp.left!= null) {
                queue.add(temp.left);
                childSize++;
            }
            if (temp.right != null) {
                queue.add(temp.right);
                childSize++;
            }
            parentSize--;
            if (parentSize == 0){
                System.out.println(list);
                ArrayList tempList = (ArrayList) list.clone();
                resultList.add(tempList);
                parentSize = childSize;
                childSize = 0;
                System.out.println();

                list.removeAll(list);
            }

        }while (!queue.isEmpty());
        return resultList;

    }
/**
 * 将每层结果放入栈内
 * */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here

        Stack<ArrayList> stack = new Stack();
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        ArrayList tempList = new ArrayList();
        Queue queue = new LinkedList();
        if (root == null)
            return resultList;
        queue.add(root);
        int childSize = 0;
        int parentSize = 1;
        TreeNode  temp;
        do {
            temp = (TreeNode) queue.poll();
            tempList.add(temp.val);
            if (temp.left != null){
                queue.add(temp.left);
                childSize++;
            }
            if (temp.right !=   null){
                queue.add(temp.right);
                childSize++;
            }
            parentSize--;
            if (parentSize == 0){
                ArrayList list = (ArrayList) tempList.clone();
                stack.push(list);
                parentSize = childSize;
                childSize = 0;
                tempList.removeAll(tempList);
            }
        }while (!queue.isEmpty());

        while (!stack.isEmpty()){
            ArrayList list = stack.pop();
            resultList.add(list);
        }
        return resultList;
    }




    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.left.left = new TreeNode(5);
        Solution test = new Solution();
        System.out.println(test.levelOrder(tree));
        System.out.println(test.levelOrderBottom(tree));
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