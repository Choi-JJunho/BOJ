import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = 0;
            int m = 0;
            int x = 0;
            int y = 0;
            boolean flag = false;
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            while (stringTokenizer.hasMoreTokens()) {
                m = Integer.parseInt(stringTokenizer.nextToken());
                n = Integer.parseInt(stringTokenizer.nextToken());
                x = Integer.parseInt(stringTokenizer.nextToken()) - 1;
                y = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            }

            for (int j = x; j < (n * m); j += m) {
                if (j % n == y) {
                    flag = true;
                    sb.append(j+1).append("\n");
                    break;
                }
            }
            if (!flag) {
                sb.append(-1).append("\n");
            }
        }
        bufferedWriter.write(sb.toString());
        bufferedWriter.flush();
    }
}
