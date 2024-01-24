import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int[][] ARR;
    static boolean[][] VISIT;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());

        ARR = new int[N + 1][N + 1];
        VISIT = new boolean[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                int num = input.charAt(j) - '0';
                ARR[i][j] = num;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (ARR[i][j] == 1 && !VISIT[i][j]) {
                    result.add(bfs(i, j));
                }
            }
        }

        result.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append('\n');
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append('\n');
        }
        bufferedWriter.write(sb.toString());
        bufferedWriter.flush();
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    private static int bfs(int y, int x) {
        int cnt = 1;
        VISIT[y][x] = true;
        Queue<Point> queue = new LinkedList();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N
                        && !VISIT[nextY][nextX] && ARR[nextY][nextX] == 1) {

                    queue.add(new Point(nextX, nextY));
                    cnt++;
                    VISIT[nextY][nextX] = true;
                }
            }
        }
        return cnt;
    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
