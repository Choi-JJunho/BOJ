class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] chars = s.toCharArray();
        char idx = '0';
        int[] cnt = new int[3];
        for (int i = 0; i < chars.length; i++) {
            if (idx == '0') {
                idx = chars[i];
                cnt[0] = 1;
                cnt[1] = 0;
                cnt[2]++;
                continue;
            }
            
            if (chars[i] == idx) {
                cnt[0]++;
            } else {
                cnt[1]++;
            }
            cnt[2]++;
            if (cnt[0] == cnt[1]) {
                answer++;
                idx = '0';
                cnt[2] = 0;
            }
        }
        if (cnt[2] != 0) {
            answer++;
        }
        return answer;
    }
}