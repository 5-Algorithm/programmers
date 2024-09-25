/*
정확성  테스트
테스트 1 〉	통과 (0.02ms, 73.5MB)
테스트 2 〉	통과 (0.04ms, 71.7MB)
테스트 3 〉	통과 (0.07ms, 76.9MB)
테스트 4 〉	통과 (0.11ms, 77.3MB)
테스트 5 〉	통과 (0.17ms, 76.8MB)
테스트 6 〉	통과 (0.37ms, 79.2MB)
테스트 7 〉	통과 (0.45ms, 77.1MB)
테스트 8 〉	통과 (0.73ms, 77MB)
테스트 9 〉	통과 (0.95ms, 77.9MB)
테스트 10 〉	통과 (1.46ms, 75.8MB)

효율성  테스트
테스트 1 〉	통과 (55.60ms, 221MB)
테스트 2 〉	통과 (52.67ms, 218MB)
테스트 3 〉	통과 (50.90ms, 215MB)
테스트 4 〉	통과 (51.08ms, 213MB)
테스트 5 〉	통과 (44.14ms, 216MB)
테스트 6 〉	통과 (47.02ms, 219MB)
테스트 7 〉	통과 (49.37ms, 226MB)
*/

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int l = board.length;
        int m = board[0].length;
        int[][] nboard = new int[l + 1][m + 1];
        
        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            
            if (type == 1) {
                nboard[r1][c1] -= degree;
                nboard[r1][c2 + 1] += degree;
                nboard[r2 + 1][c1] += degree;
                nboard[r2 + 1][c2 + 1] -= degree;
            } else if (type == 2) {
                nboard[r1][c1] += degree;
                nboard[r1][c2 + 1] -= degree;
                nboard[r2 + 1][c1] -= degree;
                nboard[r2 + 1][c2 + 1] += degree;
            }
        }
        
        for (int i = 0; i <= l; i++) { // 왼쪽에서 오른쪽으로 누적
            for (int j = 0; j < m; j++) {
                nboard[i][j+1] += nboard[i][j];
            }
        }
        
        for (int i = 0; i < l; i++) { // 위에서 아래로 누적
            for (int j = 0; j <= m; j++) {
                nboard[i+1][j] += nboard[i][j];
            }
        }
        
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += nboard[i][j];
                if (board[i][j] > 0) answer++;
            }
        }
              
        return answer;
    }
}
