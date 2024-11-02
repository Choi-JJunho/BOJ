class Solution {
    public int[] solution(int brown, int yellow) {
        // 노란색 영역의 가능한 세로 길이를 탐색
        for (int height_y = 1; height_y <= Math.sqrt(yellow); height_y++) {
            if (yellow % height_y == 0) {
                int width_y = yellow / height_y;
                
                // 전체 카펫의 크기를 계산
                int width = width_y + 2;
                int height = height_y + 2;
                
                if (2 * (width + height) - 4 == brown) {
                    return new int[] {width, height};
                }
            }
        }
        return new int[] {};
    }
}