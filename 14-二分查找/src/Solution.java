public class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            int middle = nums[(left+right)/2];
            if (target >  middle){
                left = (left+right)/2;
            }else if (target < middle){
                right = (left+right)/2;
            }
            else
                return (left+right)/2;
        }
        return -1;
    }
}