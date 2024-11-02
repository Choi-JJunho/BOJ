class Solution {
    public int[] solution(String s) {
        String target = s;
        int cnt = 0;
        int res = 0;
        while (!"1".equals(target)) {
            for (char c : target.toCharArray()) {
                if (c == '0') {
                    cnt++;
                }
            }
            target = target.replaceAll("0", "");
            int len = target.length();
            StringBuilder sb = new StringBuilder();
            target = Integer.toBinaryString(len);
            res++;
        }
        
        return new int[]{res, cnt};
    }
}