import java.util.*;

class Solution {
    
    char[] open = {'(', '{', '['};
    char[] close = {')', '}', ']'};
    
    public int solution(String s) {
        int answer = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chars.length; j++) {
                sb.append(chars[(i + j) % chars.length]);
            }
            if (isCorrect(sb.toString())) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isCorrect(String x) {
        char[] chars = x.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                    stack.push(0);
                    break;
                case '{':
                    stack.push(1);
                    break;
                case '[':
                    stack.push(2);
                    break;
                default:
                    if (stack.isEmpty()) {
                        return false;
                    }
                    int idx = stack.pop();
                    if (close[idx] != chars[i]) {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
}