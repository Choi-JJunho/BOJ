import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bufferedReader.readLine());
        Map<Integer, Integer> heap = new HashMap<>();
        Map<Integer, Integer> negative = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            if (num == 0) {
                if (heap.isEmpty()) {
                    sb.append(0).append("\n");
                    continue;
                }
                int min = 0;
                if (!minHeap.isEmpty()) {
                    min = minHeap.poll();
                }
                if (negative.containsKey(min)) {
                    sb.append(-min).append("\n");
                    negative.put(min, negative.get(min) - 1);
                    if (negative.get(min) == 0) {
                        negative.remove(min);
                    }
                } else {
                    sb.append(min).append("\n");
                }
                if (heap.containsKey(min)) {
                    heap.put(min, heap.get(min) - 1);
                    if (heap.get(min) == 0) {
                        heap.remove(min);
                    }
                }
            } else {
                int target = Math.abs(num);
                if (num < 0) {
                    negative.put(target, negative.getOrDefault(target, 0) + 1);
                }
                heap.put(target, heap.getOrDefault(target, 0) + 1);
                minHeap.add(target);
            }
        }
        bufferedWriter.write(sb.toString());
        bufferedWriter.flush();
    }
}
