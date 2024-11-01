class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long x1 = x, x2 = x;
        long y1 = y, y2 = y;
        
        // Iterate over the queries in reverse order
        for (int i = queries.length - 1; i >= 0; i--) {
            int direction = queries[i][0];
            int step = queries[i][1];
            
            switch(direction) {
                case 0: // LEFT -> RIGHT
                    if (y1 != 0) y1 += step;
                    y2 = Math.min(y2 + step, m - 1);
                    if (y1 > m - 1) return 0;
                    break;
                case 1: // RIGHT -> LEFT
                    if (y2 != m - 1) y2 -= step;
                    y1 = Math.max(y1 - step, 0);
                    if (y2 < 0) return 0;
                    break;
                case 2: // UP -> DOWN
                    if (x1 != 0) x1 += step;
                    x2 = Math.min(x2 + step, n - 1);
                    if (x1 > n - 1) return 0;
                    break;
                case 3: // DOWN -> UP
                    if (x2 != n - 1) x2 -= step;
                    x1 = Math.max(x1 - step, 0);
                    if (x2 < 0) return 0;
                    break;
            }
        }
        return (x2 - x1 + 1) * (y2 - y1 + 1);
    }
}
