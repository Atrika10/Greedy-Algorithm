import java.util.*;
public class SplitString {

    // TC => O(n), where n is the length of the given string

    public static int balancedStringSplit(String s) {
        int countR =0 , countL = 0, countStr =0; // to track my no of R,L char & no of substring that I can obtain
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'R') {
                countR++;
            }else{
                countL++;
            }
            sb.append(ch);

            // after appending char each time I'll check if countR == countL
            if (countR == countL) {  // means I got the balanced substr
                countStr++;
                sb = new StringBuilder(""); // reinitialize
                countL = 0;
                countR = 0;
            }
        }
        return countStr;
    }

    public static void main(String[] args) {
        String s = "LLLLRRRR"; // 2 max substr
        System.out.println("Max no of balanced sub string I can obtain : " +  balancedStringSplit(s));
    }
    
}
