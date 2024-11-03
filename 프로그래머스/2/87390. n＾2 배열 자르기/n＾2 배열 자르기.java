import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> list = new ArrayList<>();
        
        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;
            list.add((int)(Math.max(row, col) + 1));
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}
