// 정확성  테스트
// 테스트 1 〉	통과 (3.41ms, 85.2MB)
// 테스트 2 〉	통과 (3.57ms, 74.9MB)
// 테스트 3 〉	통과 (3.31ms, 67.3MB)
// 테스트 4 〉	통과 (2.27ms, 74.4MB)
// 테스트 5 〉	통과 (3.45ms, 78.1MB)
// 테스트 6 〉	통과 (1.23ms, 76.6MB)
// 테스트 7 〉	통과 (3.14ms, 77.6MB)
// 테스트 8 〉	통과 (1.71ms, 82.6MB)
// 테스트 9 〉	통과 (1.87ms, 72.4MB)
// 테스트 10 〉	통과 (3.61ms, 76.9MB)
// 테스트 11 〉	통과 (1.50ms, 74MB)
// 테스트 12 〉	통과 (1.00ms, 75MB)
// 테스트 13 〉	통과 (1.45ms, 82.2MB)
// 테스트 14 〉	통과 (1.24ms, 71.3MB)
// 테스트 15 〉	통과 (1.59ms, 77.1MB)
// 테스트 16 〉	통과 (1.52ms, 76.3MB)
// 테스트 17 〉	통과 (1.33ms, 75.4MB)
// 테스트 18 〉	통과 (1.07ms, 78.4MB)
// 테스트 19 〉	통과 (1.46ms, 80.8MB)
// 테스트 20 〉	통과 (1.01ms, 68.9MB)

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int time = 0;
        int answer = 0;
        int jobCount = 0;
        int i = 0;
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        while (jobCount < jobs.length) {
            while (i < jobs.length && jobs[i][0] <= time) {
                pq.offer(jobs[i++]);
            }
            if (!pq.isEmpty()) {
                int[] curr = pq.poll();
                time += curr[1];
                answer += time - curr[0];
                jobCount++;
            } else if (i < jobs.length) {
                time = jobs[i][0];
            }
        }
        
        answer /= jobs.length;
        return answer;
    }
}
