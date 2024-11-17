import java.util.*;
import java.io.*;

class Main {

    static int[][] dp;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        
	    for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k];
                }
                dp[i][j] %= 10007;
            }
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res += dp[n][i];
        }
        bw.write(String.valueOf(res % 10007));
        bw.flush();
    }
}