import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static int[] arr;
    static int[] nums;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());
        arr = new int[N + 1];
        nums = new int[10];
        int i = 0;
        while (stk.hasMoreTokens()) {
            int num = Integer.parseInt(stk.nextToken());
            arr[i++] = num;
        }
        sb.append(twoPointer(0, 0, 0, 0, 0));
        bufferedWriter.write(sb.toString());
        bufferedWriter.flush();
    }

    public static int twoPointer(int left, int right, int cnt, int kind, int max) {
        if (right >= N) {
            return max;
        }

        if (nums[arr[right]] == 0) {
            kind++;
        }
        cnt++;
        nums[arr[right]]++;

        if (kind > 2) {
            if (--nums[arr[left]] == 0) {
                kind--;
            }
            left++;
            cnt--;
        }
        max = Math.max(cnt, max);
        return twoPointer(left, right + 1, cnt, kind, max);
    }
}
