import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            if (N > 32) {
                sb.append(0).append('\n');
            } else {
                String[] arr = new String[N];
                for (int j = 0; j < N; j++) {
                    String input = stringTokenizer.nextToken();
                    arr[j] = input;
                }
                int result = Integer.MAX_VALUE;
                for (int j = 0; j < N; j++) {
                    for (int k = j + 1; k < N; k++) {
                        for (int l = k + 1; l < N; l++) {
                            if (result == 0) {
                                continue;
                            }
                            result = Math.min(result, compare(arr[j], arr[k], arr[l]));
                        }
                    }
                }
                sb.append(result).append('\n');
            }
        }
        bufferedWriter.write(sb.toString());
        bufferedWriter.flush();
    }

    private static int compare(String a, String b, String c) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += a.charAt(i) == b.charAt(i) ? 0 : 1;
            result += b.charAt(i) == c.charAt(i) ? 0 : 1;
            result += a.charAt(i) == c.charAt(i) ? 0 : 1;
        }
        return result;
    }
}