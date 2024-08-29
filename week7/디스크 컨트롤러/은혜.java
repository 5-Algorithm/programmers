import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int jobCnt = jobs.length;
        int jobIdx = 0; 
        int time = 0;
        int count = 0; // 작업이 끝난 개수
        
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]);
        
        while(count<jobCnt){
            while(jobIdx<jobCnt && jobs[jobIdx][0] <= time){
                pq.add(jobs[jobIdx++]);
            }
            
            if(!pq.isEmpty()){
                int[] cur = pq.poll();
                time += cur[1];
                answer += (time-cur[0]);
                count++;
            } else {
                time = jobs[jobIdx][0];
            }
        }
        
        answer = answer/jobCnt;
        return answer;
    }
}


/*
정확성  테스트
테스트 1 〉	통과 (2.31ms, 80.6MB)
테스트 2 〉	통과 (2.27ms, 78.7MB)
테스트 3 〉	통과 (2.62ms, 82.3MB)
테스트 4 〉	통과 (3.29ms, 77.9MB)
테스트 5 〉	통과 (2.62ms, 77MB)
테스트 6 〉	통과 (1.09ms, 67.2MB)
테스트 7 〉	통과 (2.42ms, 79.6MB)
테스트 8 〉	통과 (2.67ms, 81.9MB)
테스트 9 〉	통과 (1.56ms, 74.4MB)
테스트 10 〉	통과 (3.85ms, 77.8MB)
테스트 11 〉	통과 (1.10ms, 80.5MB)
테스트 12 〉	통과 (1.12ms, 71.2MB)
테스트 13 〉	통과 (1.58ms, 74.7MB)
테스트 14 〉	통과 (1.05ms, 72.2MB)
테스트 15 〉	통과 (1.22ms, 73MB)
테스트 16 〉	통과 (2.55ms, 76.8MB)
테스트 17 〉	통과 (1.07ms, 73.9MB)
테스트 18 〉	통과 (1.25ms, 75.1MB)
테스트 19 〉	통과 (1.08ms, 75.7MB)
테스트 20 〉	통과 (0.95ms, 73.2MB)
*/
