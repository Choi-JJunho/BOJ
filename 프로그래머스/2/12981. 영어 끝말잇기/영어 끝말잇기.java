import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        char prev = words[0].charAt(0);
        char curr = prev;
        for (int i = 0; i < words.length; i++) {
            curr = words[i].charAt(0);
            if (curr != prev || set.contains(words[i])) {
                System.out.println("i: " + i + " n:" + n);
                if ((i + 1) % n != 0) {
                    return new int[] {(i % n + 1), (i + 1) / n + 1};
                }
                return new int[] {(i % n + 1), (i + 1) / n};
            }
            prev = words[i].charAt(words[i].length() - 1);
            set.add(words[i]);
        }
        return new int[] {0, 0};
    }
}