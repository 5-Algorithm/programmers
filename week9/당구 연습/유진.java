import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];

            int tmp = 0; 
            int result = Integer.MAX_VALUE;

            // 좌 
            // (targetX, targetY)를 좌측 벽에 반사시키면 (-targetX, targetY)
            if (!(startY == targetY && startX >= targetX)) {
                tmp = distance(startX, startY, targetX * (-1), targetY);
                result = Math.min(tmp, result);
            }

            // 우
            if (!(startY == targetY && startX <= targetX)) {
                tmp = distance(startX, startY, m + (m - targetX), targetY);
                result = Math.min(tmp, result);
            }

            // 상
            if (!(startX == targetX && startY <= targetY)) {
                tmp = distance(startX, startY, targetX, n + (n - targetY));
                result = Math.min(tmp, result);
            }

            // 하
            if (!(startX == targetX && startY >= targetY)) {
                tmp = distance(startX, startY, targetX, targetY * (-1));
                result = Math.min(tmp, result);
            }
            answer[i] = result;
        }

        return answer;
    }

    public int distance(int ax, int ay, int bx, int by) {
        return (int) (Math.pow(ax - bx, 2) + Math.pow(ay - by, 2));
    }
}

// 테스트 1 〉	통과 (0.61ms, 81.4MB)
// 테스트 2 〉	통과 (0.50ms, 84.3MB)
// 테스트 3 〉	통과 (0.15ms, 80.9MB)
// 테스트 4 〉	통과 (0.41ms, 83.9MB)
// 테스트 5 〉	통과 (0.09ms, 76.9MB)
// 테스트 6 〉	통과 (0.38ms, 89.4MB)
// 테스트 7 〉	통과 (0.45ms, 80.9MB)
// 테스트 8 〉	통과 (0.39ms, 80.3MB)
// 테스트 9 〉	통과 (0.23ms, 78.8MB)
// 테스트 10 〉	통과 (0.37ms, 70.3MB)
// 테스트 11 〉	통과 (0.37ms, 81.3MB)
// 테스트 12 〉	통과 (0.60ms, 76.7MB)
// 테스트 13 〉	통과 (0.65ms, 82.8MB)
// 테스트 14 〉	통과 (0.07ms, 74.5MB)
// 테스트 15 〉	통과 (0.48ms, 67.5MB)
// 테스트 16 〉	통과 (0.38ms, 78.9MB)
// 테스트 17 〉	통과 (0.20ms, 86.6MB)
// 테스트 18 〉	통과 (0.46ms, 77.5MB)
// 테스트 19 〉	통과 (0.39ms, 80MB)
// 테스트 20 〉	통과 (0.47ms, 77.6MB)
// 테스트 21 〉	통과 (0.59ms, 84.1MB)
// 테스트 22 〉	통과 (0.45ms, 77.9MB)
// 테스트 23 〉	통과 (0.14ms, 73.9MB)
// 테스트 24 〉	통과 (0.49ms, 80.5MB)
// 테스트 25 〉	통과 (0.37ms, 75.3MB)
// 테스트 26 〉	통과 (0.32ms, 87.4MB)
// 테스트 27 〉	통과 (0.14ms, 77MB)
// 테스트 28 〉	통과 (0.47ms, 80.3MB)
// 테스트 29 〉	통과 (0.04ms, 76.2MB)
// 테스트 30 〉	통과 (0.04ms, 80.3MB)
// 테스트 31 〉	통과 (0.48ms, 80.2MB)
// 테스트 32 〉	통과 (0.54ms, 75.2MB)
// 테스트 33 〉	통과 (0.08ms, 75.4MB)
// 테스트 34 〉	통과 (0.51ms, 79.5MB)
// 테스트 35 〉	통과 (0.08ms, 73.6MB)
// 테스트 36 〉	통과 (0.42ms, 87MB)
