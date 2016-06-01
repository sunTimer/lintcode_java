import java.util.ArrayList;

/**
 * Created by shixu on 2016-05-23.
 */
public class Solution3 {
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 == null)
            return true;
        if (T1 != null && T2 == null)
            return true;
        if (T1 == null && T2 != null)
            return false;
        if (T1.val == T2.val) {
            if (check(T1, T2))
                return true;
        }
        if (isSubtree(T1.left, T2) || isSubtree(T1.right, T2))
            return true;
        return false;
    }

    private boolean check(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 == null)
            return true;
        if (T1 == null || T2 == null)
            return false;
        if (T1.val == T2.val)
            return check(T1.left, T2.left) && check(T1.right, T2.right);
        return false;
    }
}
