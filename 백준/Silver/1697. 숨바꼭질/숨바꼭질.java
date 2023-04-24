import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int max = 100002;
    static int[] arr = new int[max];
    static Queue<Integer> list = new LinkedList<>();

    static int from;
    static int target;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        from = Integer.parseInt(stringTokenizer.nextToken());
        target = Integer.parseInt(stringTokenizer.nextToken());

        list.add(from);
        if (from != target) {
            while (!list.isEmpty()) {
                Integer pop = list.poll();
                bfs(pop + 1, arr[pop]);
                bfs(pop - 1, arr[pop]);
                bfs(pop * 2, arr[pop]);
            }
        }

        bufferedWriter.write(String.valueOf(arr[target]));

        bufferedWriter.flush();
    }

    private static void bfs(int index, int origin) {
        if (index < 0 || index >= max) return;

        if (arr[index] == 0) {
            arr[index] = origin + 1;
            list.add(index);
        } else {
            arr[index] = Math.min(origin + 1, arr[index]);
        }
    }
}
