import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toLowerCase().toCharArray();
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                sb.append(' ');
                flag = true;
                continue;
            }
            if (flag && 'a' <= chars[i] && chars[i] <= 'z') {
                sb.append((char) (chars[i] - 'a' + 'A'));
                flag = false;
            } else {
                sb.append(chars[i]);
                flag = false;
            }
        }
        return sb.toString();
    }
}