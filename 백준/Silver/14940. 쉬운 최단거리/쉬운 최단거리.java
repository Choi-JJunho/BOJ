import java.io.*;
import java.util.*;

class Main {

    static int[][] arr;
    static int[][] route;
    static boolean[][] visit;
    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[n + 1][m + 1];
        route = new int[n + 1][m + 1];
        visit = new boolean[n + 1][m + 1];

        int startX = 1;
        int startY = 1;

        for (int i = 1; i <= n; i++) {
            StringTokenizer input = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= m; j++) {
                int number = Integer.parseInt(input.nextToken());
                arr[i][j] = number;
                if (number == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!visit[i][j] && arr[i][j] == 1) {
                    bufferedWriter.write(String.format("%d ", -1));
                } else {
                    bufferedWriter.write(String.format("%d ", route[i][j]));
                }
            }
            bufferedWriter.write(System.lineSeparator());
        }

        bufferedWriter.flush();
    }

    public static void bfs(int x, int y) {
        int[] dy = new int[]{0, 0, 1, -1};
        int[] dx = new int[]{1, -1, 0, 0};

        visit[x][y] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX < 1 || nextY < 1 || nextX > n || nextY > m || visit[nextX][nextY] || arr[nextX][nextY] == 0) {
                    continue;
                }

                route[nextX][nextY] = route[current.x][current.y] + 1;
                visit[nextX][nextY] = true;
                queue.add(new Point(nextX, nextY));
            }
        }
    }

    public static class Point {

        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
