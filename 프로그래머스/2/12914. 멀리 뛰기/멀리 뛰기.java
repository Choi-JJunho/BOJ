class Solution {
    public long solution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        int mod = 1234567;
        int a = 1; // f(1)
        int b = 2; // f(2)
        
        for (int i = 3; i <= n; i++) {
            int next = (a + b) % mod;
            a = b;
            b = next;
        }
        
        return b;
    }
}