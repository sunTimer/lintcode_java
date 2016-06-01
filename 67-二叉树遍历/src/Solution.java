import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shixu on 2016-05-17.
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        Solution test = new Solution();
        System.out.println("中序："+test.inorderTraversal(tree).toString());
        System.out.println("先序："+test.preorderTraversal(tree).toString());
        System.out.println("后序："+test.postorderTraversal(tree).toString());
        System.out.println("层次："+test.levelOrder(tree));
    }
    /**
     * 二叉树层次遍历
     * */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
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
                System.out.println("--------");
                list.removeAll(list);
            }

        }while (!queue.isEmpty());
        return resultList;

    }


    /**
     * \
     * 中序遍历
     *
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here\
        ArrayList listNode = new ArrayList();
        return inorderRes(root, listNode);

    }


    private ArrayList inorderRes(TreeNode root, ArrayList listNode) {
        if (root == null)
            return listNode;
  /*      if (root.left == null) {
            listNode.add(root.val);
            inorderRes(root.right, listNode);
        } else {
            TreeNode temp = root;
            inorderRes(root.left, listNode);
            listNode.add(temp.val);
            inorderRes(root.right, listNode);
        }*/


        if(root.left!= null){
            inorderRes(root.left.left,listNode);
            listNode.add(root.left.val);
            inorderRes(root.left.right,listNode);
        }
        listNode.add(root.val);
        if (root.right!= null){
            inorderRes(root.right.left,listNode);
            listNode.add(root.right.val);
            inorderRes(root.right.right,listNode);
        }
        return listNode;

    }
    /**
     * 先序遍历
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here\
        ArrayList listNode = new ArrayList();
        return preorderRes(root, listNode);

    }

    private ArrayList preorderRes(TreeNode root, ArrayList listNode) {
        if (root == null)
            return listNode;
        listNode.add(root.val);
        if (root.left != null) {
            listNode.add(root.left.val);
            preorderRes(root.left.left, listNode);
            preorderRes(root.left.right, listNode);
        }
        if (root.right != null) {
            listNode.add(root.right.val);
            preorderRes(root.right.left, listNode);
            preorderRes(root.right.right, listNode);
        }
        return listNode;

    }

    /**
     * 后序遍历
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList listNode = new ArrayList();
        return postorderRes(root, listNode);
    }

    private ArrayList<Integer> postorderRes(TreeNode root, ArrayList listNode) {
        if (root == null)
            return listNode;
        if (root.left != null) {
            postorderRes(root.left.left, listNode);
            postorderRes(root.left.right, listNode);
            listNode.add(root.left.val);
        }
        if (root.right != null) {
            postorderRes(root.right.left, listNode);
            postorderRes(root.right.right, listNode);
            listNode.add(root.right.val);
        }
        listNode.add(root.val);
        return listNode;
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