import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet();
        int i = 1;
        while (i <= elements.length) {
            for (int j = 0; j < elements.length; j++) {
                int tmp = 0;
                for (int k = 0; k < i; k++) {
                    tmp += elements[(j + k) % elements.length];
                }
                set.add(tmp);
            }
            i++;
        }
        return set.size();
    }
}