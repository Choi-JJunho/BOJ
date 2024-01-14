import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int M;
    static boolean[][] VISIT;
    static int[][] ARR;
    static int[][] DIST;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        ARR = new int[N + 1][M + 1];
        VISIT = new boolean[N + 1][M + 1];
        DIST = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String input = bufferedReader.readLine();
            for (int j = 1; j <= M; j++) {
                ARR[i][j] = Integer.parseInt(String.valueOf(input.charAt(j - 1)));
            }
        }

        bfs(1, 1);
        bufferedWriter.write(String.valueOf(DIST[N][M]));
        bufferedWriter.flush();
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        DIST[x][y] = 1;
        VISIT[x][y] = true;
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (0 < nextX && nextX <= N && 0 < nextY && nextY <= M
                    && !VISIT[nextX][nextY] && ARR[nextX][nextY] == 1) {
                    DIST[nextX][nextY] = DIST[current.x][current.y] + 1;
                    VISIT[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY));
                }
            }
        }
    }

    public static class Point {

        public int x;
        public int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
