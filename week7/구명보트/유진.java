import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] people, int limit) {
        Deque<Integer> que = new ArrayDeque<>();
        int n = people.length;
        Arrays.sort(people);
        for(int i =0;i<n;i++){
            que.addLast(people[i]);
        }
        int answer = 0;
        
        while(!que.isEmpty()){
            int p = que.removeLast();
            if(!que.isEmpty()){
                int q= que.getFirst();
                if(p+q<=limit){
                    que.removeFirst();
                }
            }
               answer++;
        }
        
  
        return answer;
    }
}

// 테스트 1 〉	통과 (3.29ms, 79.5MB)
// 테스트 2 〉	통과 (4.54ms, 88.1MB)
// 테스트 3 〉	통과 (4.25ms, 77.6MB)
// 테스트 4 〉	통과 (3.76ms, 82.9MB)
// 테스트 5 〉	통과 (2.85ms, 75.6MB)
// 테스트 6 〉	통과 (2.54ms, 73.2MB)
// 테스트 7 〉	통과 (2.70ms, 77.3MB)
// 테스트 8 〉	통과 (0.62ms, 75.4MB)
// 테스트 9 〉	통과 (0.90ms, 66.8MB)
// 테스트 10 〉	통과 (3.35ms, 76.4MB)
// 테스트 11 〉	통과 (3.66ms, 74.4MB)
// 테스트 12 〉	통과 (2.64ms, 75.9MB)
// 테스트 13 〉	통과 (3.98ms, 77MB)
// 테스트 14 〉	통과 (2.63ms, 73MB)
// 테스트 15 〉	통과 (1.13ms, 74.1MB)
// 테스트 16 〉	통과 (1.27ms, 76.3MB)
// 테스트 17 〉	통과 (0.54ms, 73.2MB)
// 테스트 18 〉	통과 (0.85ms, 73MB)
// 테스트 19 〉	통과 (0.55ms, 70.4MB)
// 테스트 20 〉	통과 (0.63ms, 69.9MB)
// 테스트 21 〉	통과 (0.70ms, 77.8MB)
// 테스트 22 〉	통과 (0.50ms, 73.3MB)
// 효율성  테스트
// 테스트 1 〉	통과 (34.73ms, 57.1MB)
// 테스트 2 〉	통과 (19.71ms, 54.5MB)
// 테스트 3 〉	통과 (23.83ms, 54.3MB)
// 테스트 4 〉	통과 (26.23ms, 72.6MB)
// 테스트 5 〉	통과 (26.13ms, 71.4MB)
