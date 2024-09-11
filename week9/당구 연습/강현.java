// 테스트 1 〉	통과 (0.79ms, 88.5MB)
// 테스트 2 〉	통과 (1.58ms, 80.2MB)
// 테스트 3 〉	통과 (0.11ms, 72.9MB)
// 테스트 4 〉	통과 (0.76ms, 80.9MB)
// 테스트 5 〉	통과 (0.14ms, 81.7MB)
// 테스트 6 〉	통과 (0.48ms, 81.3MB)
// 테스트 7 〉	통과 (0.70ms, 79.4MB)
// 테스트 8 〉	통과 (0.19ms, 77.9MB)
// 테스트 9 〉	통과 (0.30ms, 76.2MB)
// 테스트 10 〉	통과 (0.48ms, 79.2MB)
// 테스트 11 〉	통과 (0.51ms, 78.5MB)
// 테스트 12 〉	통과 (0.86ms, 82.8MB)
// 테스트 13 〉	통과 (0.92ms, 78.4MB)
// 테스트 14 〉	통과 (0.09ms, 78.3MB)
// 테스트 15 〉	통과 (0.39ms, 79.3MB)
// 테스트 16 〉	통과 (0.50ms, 79.7MB)
// 테스트 17 〉	통과 (0.23ms, 78.3MB)
// 테스트 18 〉	통과 (0.47ms, 86.6MB)
// 테스트 19 〉	통과 (0.41ms, 76.7MB)
// 테스트 20 〉	통과 (0.47ms, 84.5MB)
// 테스트 21 〉	통과 (0.62ms, 86.8MB)
// 테스트 22 〉	통과 (0.57ms, 79.5MB)
// 테스트 23 〉	통과 (0.27ms, 81MB)
// 테스트 24 〉	통과 (0.57ms, 80.8MB)
// 테스트 25 〉	통과 (0.49ms, 81MB)
// 테스트 26 〉	통과 (0.32ms, 74.5MB)
// 테스트 27 〉	통과 (0.17ms, 72.7MB)
// 테스트 28 〉	통과 (0.58ms, 80.4MB)
// 테스트 29 〉	통과 (0.05ms, 73.9MB)
// 테스트 30 〉	통과 (0.06ms, 75.6MB)
// 테스트 31 〉	통과 (0.62ms, 82.8MB)
// 테스트 32 〉	통과 (0.52ms, 78.4MB)
// 테스트 33 〉	통과 (0.09ms, 76.2MB)
// 테스트 34 〉	통과 (0.43ms, 78.9MB)
// 테스트 35 〉	통과 (0.19ms, 80.8MB)
// 테스트 36 〉	통과 (0.58ms, 94.6MB)
class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i = 0; i < balls.length; i++) {
            int[] curr = balls[i];
            int currMin = Integer.MAX_VALUE;

            if (!(curr[0] < startX && curr[1] == startY)) // 왼쪽 벽
                currMin = Math.min(currMin, (int)(Math.pow(startX + curr[0], 2) + Math.pow(startY - curr[1], 2)));
            if (!(curr[1] < startY && curr[0] == startX)) // 아래쪽 벽
                currMin = Math.min(currMin, (int)(Math.pow(startX - curr[0], 2) + Math.pow(startY + curr[1], 2)));
            if (!(curr[0] > startX && curr[1] == startY)) // 오른쪽 벽
                currMin = Math.min(currMin, (int)(Math.pow(m - startX + (m - curr[0]), 2) + Math.pow(startY - curr[1], 2)));
            if (!(curr[1] > startY && curr[0] == startX)) // 위쪽 벽
                currMin = Math.min(currMin, (int)(Math.pow(startX - curr[0], 2) + Math.pow(n - startY + (n - curr[1]), 2)));
            if (!(curr[0] <= startX && curr[1] <= startY)) // 왼쪽 위 모서리
                currMin = Math.min(currMin, (int)(Math.pow(startX + curr[0], 2) + Math.pow(startY + curr[1], 2)));
            if (!(curr[0] >= startX && curr[1] <= startY)) // 오른쪽 위 모서리
                currMin = Math.min(currMin, (int)(Math.pow((m - startX) + (m - curr[0]), 2) + Math.pow(startY + curr[1], 2)));
            if (!(curr[0] <= startX && curr[1] >= startY)) // 왼쪽 아래 모서리
                currMin = Math.min(currMin, (int)(Math.pow(startX + curr[0], 2) + Math.pow((n - startY) + (n - curr[1]), 2)));
            if (!(curr[0] >= startX && curr[1] >= startY)) // 오른쪽 아래 모서리
                currMin = Math.min(currMin, (int)(Math.pow((m - startX) + (m - curr[0]), 2) + Math.pow((n - startY) + (n - curr[1]), 2)));
            answer[i] = currMin;
        }
        return answer;
    }
}
