import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());
        String input = bufferedReader.readLine();

        int cnt = 0;
        int result = 0;
        for (int i = 0; i < M - 2; i++) {
            if (input.charAt(i) == 'I' && input.charAt(i + 1) == 'O' && input.charAt(i + 2) == 'I') {
                cnt++;
                i++;
                if (cnt == N) {
                    result++;
                    cnt--;
                }
            } else {
                cnt = 0;
            }
        }
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
    }
}
