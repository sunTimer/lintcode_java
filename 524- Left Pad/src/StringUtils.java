/**
 * Created by shixu on 2016-04-24.
 */
public class StringUtils {
    /**
     * @param originalStr the string we want to append to with spaces
     * @param size the target length of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size) {
        // Write your code here
        int num = size - originalStr.length();
        if (num <= 0)
            return originalStr;
        String temp =  "";
        String padStr = " ";
        for(int i=0; i<num; i++){
            temp+=padStr;
        }
        return temp+originalStr;
    }

    /**
     * @param originalStr the string we want to append to
     * @param size the target length of the string
     * @param padChar the character to pad to the left side of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        // Write your code here
        int num = size - originalStr.length();
        if (num <= 0)
            return originalStr;
        String temp =  "";
        String padStr = padChar+"";
        for(int i=0; i<num; i++){
            temp+=padStr;
        }
        return temp+originalStr;
    }

    public static void main(String[] args) {
        System.out.println(StringUtils.leftPad("1", 2, '0'));
    }
}