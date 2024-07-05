import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        Map<Integer, Integer> ladder = new HashMap<>();
        Map<Integer, Integer> snake = new HashMap<>();

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            ladder.put(from, to);
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            snake.put(from, to);
        }

        int[] cnt = new int[101];
        boolean[] visit = new boolean[101];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int next = current + i;
                if (next > 100) {
                    continue;
                }
                if (snake.containsKey(next)) {
                    next = snake.get(next);
                }
                if (ladder.containsKey(next)) {
                    next = ladder.get(next);
                }
                if (!visit[next]) {
                    visit[next] = true;
                    cnt[next] = cnt[current] + 1;
                    queue.add(next);
                }
            }
        }
        sb.append(cnt[100]);
        bufferedWriter.write(sb.toString());
        bufferedWriter.flush();
    }
}
