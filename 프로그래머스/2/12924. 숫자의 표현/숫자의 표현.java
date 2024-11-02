class Solution {
    public int solution(int n) {
        int count = 0;
        int k = 1;
        
        while (k * (k - 1) / 2 < n) {
            // n - k*(k-1)/2가 k로 나누어 떨어지는지 확인
            if ((n - k * (k - 1) / 2) % k == 0) {
                count++;
            }
            k++;
        }
        
        return count;
    }
}