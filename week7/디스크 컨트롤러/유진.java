import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int size = jobs.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        int time= 0;;
        int idx =0;;
        while (idx < size && jobs[idx][0] <= time) {
                pq.offer(jobs[idx++]);
        }
            
        int sum =0;
        int cnt =0;   
        while(cnt<size){
      
            // System.out.println(sum);   
            while (idx < size && jobs[idx][0] <= time) {
                pq.offer(jobs[idx++]);
            }
            
            if (pq.isEmpty())  {
				time = jobs[idx][0];
            }else{
                int[] p =pq.poll();
                time+=p[1];
                cnt++;
                sum +=(time-p[0]);
            }
            
		}
        
        return sum/size;
    }
}

/*
테스트 1 〉	통과 (3.43ms, 81.3MB)
테스트 2 〉	통과 (2.39ms, 78MB)
테스트 3 〉	통과 (2.98ms, 72.4MB)
테스트 4 〉	통과 (2.96ms, 78.3MB)
테스트 5 〉	통과 (2.16ms, 76.4MB)
테스트 6 〉	통과 (1.09ms, 75.2MB)
테스트 7 〉	통과 (2.49ms, 76.7MB)
테스트 8 〉	통과 (1.93ms, 75.3MB)
테스트 9 〉	통과 (1.64ms, 75.4MB)
테스트 10 〉	통과 (3.50ms, 82.6MB)
테스트 11 〉	통과 (0.95ms, 72.8MB)
테스트 12 〉	통과 (1.01ms, 78.3MB)
테스트 13 〉	통과 (0.97ms, 75.5MB)
테스트 14 〉	통과 (0.99ms, 72.5MB)
테스트 15 〉	통과 (1.12ms, 76MB)
테스트 16 〉	통과 (1.02ms, 73.8MB)
테스트 17 〉	통과 (1.39ms, 78.1MB)
테스트 18 〉	통과 (1.10ms, 72.5MB)
테스트 19 〉	통과 (0.92ms, 78.6MB)
테스트 20 〉	통과 (0.90ms, 72.3MB)
*/
