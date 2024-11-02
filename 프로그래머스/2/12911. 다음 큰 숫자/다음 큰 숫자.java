class Solution {
    public int solution(int n) {
        int countOnes = Integer.bitCount(n); // n의 1의 개수를 셉니다.
        int nextNumber = n + 1; // n보다 큰 수부터 시작합니다.
        
        while (true) {
            if (Integer.bitCount(nextNumber) == countOnes) {
                return nextNumber; // 1의 개수가 같은 가장 작은 수를 찾으면 반환합니다.
            }
            nextNumber++; // 다음 수로 넘어갑니다.
        }
    }
}
