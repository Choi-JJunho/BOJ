import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int r = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());
        int size = (int) Math.pow(2, n);

        find(size, r, c);
        bufferedWriter.write(String.valueOf(count));
        bufferedWriter.flush();
    }

    private static void find(int size, int r, int c) {
        if (size == 1) {
            return;
        }
        if (r < size / 2 && c < size / 2) { // 1사분면
            find(size / 2, r, c);
        } else if (r < size / 2 && c >= size / 2) { // 2사분면
            count += (size * size) / 4;
            find(size / 2, r, c - size / 2);
        } else if (r >= size / 2 && c < size / 2) { // 3사분면
            count += (size * size) / 4 * 2;
            find(size / 2, r - size / 2, c);
        } else { // 4사분면
            count += (size * size) / 4 * 3;
            find(size / 2, r - size / 2, c - size / 2);
        }
    }
}
