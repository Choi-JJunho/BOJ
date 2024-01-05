import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int n;
    static int m;
    static char[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        arr = new char[n][m];
        visit = new boolean[n][m];
        int startX = -1;
        int startY = -1;

        for (int i = 0; i < n; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < m; j++) {
                char canMeet = input.charAt(j);
                arr[i][j] = canMeet;
                if (canMeet == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }
        int result = bfs(startX, startY);
        if (result == 0) {
            bufferedWriter.write("TT");
        } else {
            bufferedWriter.write(String.valueOf(result));
        }

        bufferedWriter.flush();
    }

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    private static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visit[x][y] = true;

        int result = 0;
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m
                    && !visit[nextX][nextY] && arr[nextX][nextY] != 'X') {

                    if (arr[nextX][nextY] == 'P') {
                        result++;
                    }

                    visit[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY));
                }
            }
        }
        return result;
    }

    private static class Point {

        public int x;
        public int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
