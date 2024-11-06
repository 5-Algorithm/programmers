/*
정확성  테스트
테스트 1 〉	통과 (0.44ms, 75.4MB)
테스트 2 〉	통과 (0.31ms, 73.7MB)
테스트 3 〉	통과 (0.32ms, 77.3MB)
테스트 4 〉	통과 (0.32ms, 74.7MB)
테스트 5 〉	통과 (0.50ms, 80.6MB)
테스트 6 〉	통과 (0.63ms, 75.8MB)
테스트 7 〉	통과 (0.52ms, 81.4MB)
테스트 8 〉	통과 (1.08ms, 78.3MB)
테스트 9 〉	통과 (0.88ms, 74.5MB)
테스트 10 〉	통과 (2.28ms, 75.8MB)
테스트 11 〉	통과 (19.46ms, 106MB)
테스트 12 〉	통과 (12.23ms, 87.5MB)
테스트 13 〉	통과 (18.42ms, 97.3MB)
테스트 14 〉	통과 (12.20ms, 95MB)
테스트 15 〉	통과 (17.91ms, 106MB)
테스트 16 〉	통과 (44.61ms, 110MB)
테스트 17 〉	통과 (49.78ms, 119MB)
테스트 18 〉	통과 (89.23ms, 161MB)
테스트 19 〉	통과 (86.22ms, 138MB)
테스트 20 〉	통과 (86.05ms, 150MB)
테스트 21 〉	통과 (87.00ms, 137MB)
테스트 22 〉	통과 (99.24ms, 161MB)
테스트 23 〉	통과 (100.58ms, 141MB)
테스트 24 〉	통과 (98.58ms, 154MB)
테스트 25 〉	통과 (0.43ms, 77.8MB)
테스트 26 〉	통과 (0.78ms, 77.4MB)
테스트 27 〉	통과 (0.39ms, 75.9MB)
테스트 28 〉	통과 (63.40ms, 112MB)
테스트 29 〉	통과 (3.68ms, 79.4MB)
테스트 30 〉	통과 (59.56ms, 119MB)
  */

import java.util.*;

class Solution {
    class Node {
        int idx, num;
        
        public Node(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Node> q1 = new LinkedList<>();
        long sum1 = 0;
        for (int i = 0; i < queue1.length; i++) {
            q1.offer(new Node(1, queue1[i]));
            sum1 += queue1[i];
        }
        
        Queue<Node> q2 = new LinkedList<>();
        long sum2 = 0;
        for (int i = 0; i < queue2.length; i++) {
            q2.offer(new Node(2, queue2[i]));
            sum2 += queue2[i];
        }
        
        int cnt = 0;
        while (sum1 != sum2) {
            if (cnt > queue1.length + queue2.length + 1) return -1;
            answer++;
            cnt++;
            if (sum1 < sum2) {
                Node curr = q2.poll();
                q1.offer(curr);
                sum1 += curr.num;
                sum2 -= curr.num;
            } else if (sum1 > sum2) {
                Node curr = q1.poll();
                q2.offer(curr);
                sum1 -= curr.num;
                sum2 += curr.num;
            }
        }
        
        return answer;
    }
}
