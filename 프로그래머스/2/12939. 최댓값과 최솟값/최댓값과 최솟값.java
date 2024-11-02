import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer stk = new StringTokenizer(s);
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        
        while(stk.hasMoreTokens()) {
            long target = Long.parseLong(stk.nextToken());
            max = Math.max(target, max);
            min = Math.min(target, min);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(min)).append(" ").append(String.valueOf(max));
        return sb.toString();
    }
}