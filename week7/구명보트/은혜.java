import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int minIdx = 0;
        
        for(int i = people.length-1; i>=minIdx; i--){
            if(limit>=people[i]+people[minIdx]){
                minIdx++;
                answer++;
            } else {
                answer++;
            }
        }
        
        return answer;
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (1.94ms, 80.3MB)
테스트 2 〉	통과 (1.40ms, 81.7MB)
테스트 3 〉	통과 (1.25ms, 74.7MB)
테스트 4 〉	통과 (1.25ms, 72MB)
테스트 5 〉	통과 (0.95ms, 76.2MB)
테스트 6 〉	통과 (0.63ms, 76.5MB)
테스트 7 〉	통과 (0.89ms, 77.4MB)
테스트 8 〉	통과 (0.42ms, 76.4MB)
테스트 9 〉	통과 (0.73ms, 72MB)
테스트 10 〉	통과 (1.19ms, 77.3MB)
테스트 11 〉	통과 (1.21ms, 82.5MB)
테스트 12 〉	통과 (1.04ms, 79.9MB)
테스트 13 〉	통과 (1.66ms, 78.4MB)
테스트 14 〉	통과 (1.27ms, 74.8MB)
테스트 15 〉	통과 (0.45ms, 74MB)
테스트 16 〉	통과 (0.42ms, 82.3MB)
테스트 17 〉	통과 (0.52ms, 71.8MB)
테스트 18 〉	통과 (0.34ms, 82MB)
테스트 19 〉	통과 (0.41ms, 75.1MB)
테스트 20 〉	통과 (0.54ms, 78.9MB)
테스트 21 〉	통과 (0.58ms, 75.6MB)
테스트 22 〉	통과 (0.40ms, 76.8MB)
효율성  테스트
테스트 1 〉	통과 (10.74ms, 56.9MB)
테스트 2 〉	통과 (9.50ms, 55.3MB)
테스트 3 〉	통과 (9.31ms, 56MB)
테스트 4 〉	통과 (6.62ms, 54.1MB)
테스트 5 〉	통과 (8.80ms, 53.8MB)
*/
