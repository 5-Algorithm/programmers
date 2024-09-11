/*
정확성  테스트
테스트 1 〉	통과 (8.86ms, 69.1MB)
테스트 2 〉	통과 (7.95ms, 75.3MB)
테스트 3 〉	통과 (1.30ms, 78.4MB)
테스트 4 〉	통과 (8.16ms, 85MB)
테스트 5 〉	통과 (4.08ms, 70.3MB)
테스트 6 〉	통과 (10.40ms, 81.7MB)
테스트 7 〉	통과 (11.30ms, 79.5MB)
테스트 8 〉	통과 (4.80ms, 73.6MB)
테스트 9 〉	통과 (4.15ms, 76MB)
테스트 10 〉	통과 (8.59ms, 75.8MB)
테스트 11 〉	통과 (7.14ms, 79.9MB)
테스트 12 〉	통과 (9.21ms, 78.6MB)
테스트 13 〉	통과 (12.32ms, 83.3MB)
테스트 14 〉	통과 (0.83ms, 75MB)
테스트 15 〉	통과 (8.09ms, 75.1MB)
테스트 16 〉	통과 (4.22ms, 77.9MB)
테스트 17 〉	통과 (7.41ms, 78.6MB)
테스트 18 〉	통과 (13.12ms, 79.4MB)
테스트 19 〉	통과 (8.63ms, 75.8MB)
테스트 20 〉	통과 (8.80ms, 79.9MB)
테스트 21 〉	통과 (9.06ms, 78.3MB)
테스트 22 〉	통과 (9.61ms, 79.9MB)
테스트 23 〉	통과 (4.41ms, 92.9MB)
테스트 24 〉	통과 (8.12ms, 82.1MB)
테스트 25 〉	통과 (11.21ms, 65.6MB)
테스트 26 〉	통과 (7.67ms, 82.6MB)
테스트 27 〉	통과 (3.51ms, 77.7MB)
테스트 28 〉	통과 (3.96ms, 80MB)
테스트 29 〉	통과 (0.05ms, 76.5MB)
테스트 30 〉	통과 (0.04ms, 64.6MB)
테스트 31 〉	통과 (11.40ms, 72.7MB)
테스트 32 〉	통과 (21.79ms, 76.4MB)
테스트 33 〉	통과 (1.15ms, 80.8MB)
테스트 34 〉	통과 (7.17ms, 76MB)
테스트 35 〉	통과 (4.64ms, 78.6MB)
테스트 36 〉	통과 (13.22ms, 81MB)
*/

class Solution {
    
    // 우, 상, 좌, 하
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int l = balls.length;
        int[] answer = new int[l];
        
        for (int i = 0; i < l; i++) {
            int[] curr = balls[i];
            long min = Long.MAX_VALUE;
            
            // 동일 선상에 있는지 체크
            selectDir: for (int dir = 0; dir < 4; dir++) {
                int nx = startX;
                int ny = startY;

                while (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (nx == curr[0] && ny == curr[1]) {
                        continue selectDir;
                    }
                    
                    nx += dx[dir];
                    ny += dy[dir];
                }
                
                // System.out.println(i + " " + dir);
                
                if (dir == 0) { // 오른쪽 대칭
                    nx = 2*m - startX;
                    ny = startY;
                }
                else if (dir == 1) { // 위쪽 대칭
                    nx = startX;
                    ny = 2*n - startY;
                }
                else if (dir == 2) {
                    nx = - startX;
                    ny = startY;
                }
                else if (dir == 3) {
                    nx = startX;
                    ny = - startY;
                }
                
                long tmp = (curr[0] - nx) * (curr[0] - nx) + (curr[1] - ny) * (curr[1] - ny);
                min = Math.min(min, tmp);
            } // selectDir
            answer[i] = (int) min;
        }
                
        return answer;
    }
}
