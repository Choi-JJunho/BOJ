import java.util.*;
import java.io.*;

class Main {
    // 1과 2와 2'의 더하기로 만들 수 있는 수열의 개수와 같다.
    // 1과 2의 더하기로 만들 수 있는 수열의 개수
    // 2와 2'로 만들 수 있는 수열의 개수
    // 1 -> 3 -> 5 -> 11 -> 21
    static int[] dp;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + 2*dp[i-2]) % 10007;
        }
        bw.write(String.valueOf(dp[n]));
        bw.flush();
    }
}