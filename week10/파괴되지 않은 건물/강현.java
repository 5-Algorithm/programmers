// 정확성  테스트
// 테스트 1 〉	통과 (0.03ms, 73.8MB)
// 테스트 2 〉	통과 (0.03ms, 75.7MB)
// 테스트 3 〉	통과 (0.06ms, 74.9MB)
// 테스트 4 〉	통과 (0.11ms, 76.1MB)
// 테스트 5 〉	통과 (0.16ms, 72.2MB)
// 테스트 6 〉	통과 (0.23ms, 75.7MB)
// 테스트 7 〉	통과 (0.31ms, 83.3MB)
// 테스트 8 〉	통과 (0.71ms, 76MB)
// 테스트 9 〉	통과 (0.58ms, 72.5MB)
// 테스트 10 〉	통과 (0.83ms, 78.4MB)
// 효율성  테스트
// 테스트 1 〉	통과 (49.81ms, 214MB)
// 테스트 2 〉	통과 (57.02ms, 214MB)
// 테스트 3 〉	통과 (46.59ms, 217MB)
// 테스트 4 〉	통과 (43.99ms, 212MB)
// 테스트 5 〉	통과 (39.88ms, 219MB)
// 테스트 6 〉	통과 (40.54ms, 219MB)
// 테스트 7 〉	통과 (40.27ms, 219MB)

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] imos = new int[board.length + 1][board[0].length + 1];
        
        for(int i = 0; i < skill.length; i++) {
            int[] curr = skill[i];
            int type = curr[0];
            int startRow = curr[1];
            int startCol = curr[2];
            int endRow = curr[3];
            int endCol = curr[4];
            int degree = type == 1 ? -curr[5] : curr[5];

            imos[startRow][startCol] += degree;
            imos[endRow + 1][endCol + 1] += degree;
            imos[startRow][endCol + 1] -= degree;
            imos[endRow + 1][startCol] -= degree;
        }
        
        for(int i = 0; i < imos.length; i++) {
            int now = 0;
            for(int j = 0; j < imos[0].length; j++) {
                now += imos[i][j];
                imos[i][j] = now;
            }
        }
        
        for(int j = 0; j < imos[0].length; j++) {
            int now = 0;
            for(int i = 0; i < imos.length; i++) {
                now += imos[i][j];
                imos[i][j] = now;
            }
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] + imos[i][j] > 0) answer++;
            }
        }
      
        return answer;
    }
}
