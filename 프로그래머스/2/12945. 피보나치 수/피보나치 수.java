class Solution {
    public int solution(int n) {
        return fibonacci(n);
    }
    
    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        
        int a = 0;
        int b = 1;
        int c = 0;
        
        for (int i = 2; i <= n; i++) {
            c = (a + b) % 1234567;
            a = b;
            b = c;
        }
        
        return c;
    }
}
