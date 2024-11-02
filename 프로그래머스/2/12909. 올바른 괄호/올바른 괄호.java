class Solution {
    boolean solution(String s) {
        int cnt = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                cnt++;
            } else {
                cnt--;
                if(cnt < 0) {
                    return false;
                }
            }
        }
        return cnt == 0;
    }
}