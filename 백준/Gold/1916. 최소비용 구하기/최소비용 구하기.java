import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int M;
    static List<List<int[]>> graph;
    static int[] dist;
    static int FROM;
    static int TO;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        // 입력 받기
        N = Integer.parseInt(bufferedReader.readLine());
        M = Integer.parseInt(bufferedReader.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(from).add(new int[]{to, weight});
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        FROM = Integer.parseInt(stringTokenizer.nextToken());
        TO = Integer.parseInt(stringTokenizer.nextToken());

        // 다익스트라 알고리즘 실행
        dijkstra(FROM);

        // 결과 출력
        bufferedWriter.write(String.valueOf(dist[TO]));
        bufferedWriter.flush();
    }

    public static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, start});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentDist = current[0];
            int currentNode = current[1];

            if (currentDist > dist[currentNode]) continue;

            for (int[] neighbor : graph.get(currentNode)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDist = currentDist + weight;

                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    pq.add(new int[]{newDist, nextNode});
                }
            }
        }
    }
}
