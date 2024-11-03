import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap();
        for (int id: tangerine) {
            map.put(id, map.getOrDefault(id, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for (int value: map.values()) {
            pq.add(value);
        }
        int answer = 0;
        while (k > 0) {
            k -= pq.poll();
            answer++;
        }
        return answer;
    }
}