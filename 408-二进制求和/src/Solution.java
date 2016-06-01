/**
 * Created by shixu on 2016-05-12.
 */
public class Solution {

    public static void main(String[] args) {

        String a = "111";
        String b = "1111";
        String result = Solution.addBinary(a,b);
        System.out.println(result);

    }


    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public static String addBinary(String a, String b) {
        // Write your code here
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        int n = 0;
        int dv = Math.abs(a.length()-b.length());
        boolean flag = false;
        if (a.length() >= b.length()){
            n = a.length();
            flag = true;
        }
        else
            n = b.length();

        int carry = 0; //进位

        StringBuilder sb = new StringBuilder();
        if (flag){  //a长度大于b
            int tempResult =0; //存放中间结果
            while (n > 0 ){

                if (n <= dv)
                    tempResult = (aChars[n-1]-'0')+carry;
                else
                    tempResult = (bChars[n-dv-1]-'0')+(aChars[n-1]-'0')+carry;
                if (tempResult == 3)
                {
                    carry = 1;
                    sb.append(1);
                }
                else if(tempResult == 2){
                    carry =1;
                    sb.append(0);
                }
                else if (tempResult == 1)
                {
                    carry = 0;
                    sb.append(1);
                }else {
                    carry = 0;
                    sb.append(0);
                }
                n--;
            }

        }
        else{
            int tempResult =0; //存放中间结果
            while (n > 0 ){
                if (n <= dv)
                    tempResult = (bChars[n-1]-'0')+carry;
                else
                    tempResult = (aChars[n-dv-1]-'0')+(bChars[n-1]-'0')+carry;

                if (tempResult == 3)
                {
                    carry = 1;
                    sb.append(1);
                }
                else if(tempResult == 2){
                    carry =1;
                    sb.append(0);
                }
                else if (tempResult == 1)
                {
                    carry = 0;
                    sb.append(1);
                }else {
                    carry = 0;
                    sb.append(0);
                }
                n--;
            }
        }

        if (carry == 1)
            sb.append(1);

        return sb.reverse().toString();
    }
}
