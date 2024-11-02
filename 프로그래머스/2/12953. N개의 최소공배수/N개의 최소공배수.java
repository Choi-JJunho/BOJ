class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            lcm = lcm(lcm, arr[i]);
        }
        
        return lcm;
    }
    
    // 두 수의 최대공약수(GCD)를 구하는 함수 (유클리드 호제법 사용)
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // 두 수의 최소공배수(LCM)를 구하는 함수
    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
