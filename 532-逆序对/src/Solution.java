/**
 * Created by shixu on 2016-04-24.
 */
public class Solution {

    /**
     * @param A an array
     * @return total of reverse pairs
     */
    public static long reversePairs(int[] A) {
        int count =0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                if (A[i] > A[j])
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a[] = {2, 4, 1, 3, 5};
        System.out.println(Solution.reversePairs(a));
    }
}
