// 정확성  테스트
// 테스트 1 〉	통과 (1.70ms, 84.4MB)
// 테스트 2 〉	통과 (1.29ms, 84.7MB)
// 테스트 3 〉	통과 (1.18ms, 72.4MB)
// 테스트 4 〉	통과 (1.96ms, 65.4MB)
// 테스트 5 〉	통과 (0.83ms, 74.6MB)
// 테스트 6 〉	통과 (0.68ms, 73.8MB)
// 테스트 7 〉	통과 (0.74ms, 66.1MB)
// 테스트 8 〉	통과 (0.48ms, 76.3MB)
// 테스트 9 〉	통과 (0.62ms, 73.8MB)
// 테스트 10 〉	통과 (1.04ms, 73.4MB)
// 테스트 11 〉	통과 (1.20ms, 66.5MB)
// 테스트 12 〉	통과 (1.01ms, 78.2MB)
// 테스트 13 〉	통과 (1.00ms, 79.9MB)
// 테스트 14 〉	통과 (1.35ms, 76.1MB)
// 테스트 15 〉	통과 (0.43ms, 66.2MB)
// 테스트 16 〉	통과 (0.49ms, 69.2MB)
// 테스트 17 〉	통과 (0.38ms, 71.6MB)
// 테스트 18 〉	통과 (0.38ms, 78.3MB)
// 테스트 19 〉	통과 (0.47ms, 75.1MB)
// 테스트 20 〉	통과 (0.40ms, 76MB)
// 테스트 21 〉	통과 (0.51ms, 77.9MB)
// 테스트 22 〉	통과 (0.47ms, 77.4MB)
// 효율성  테스트
// 테스트 1 〉	통과 (11.05ms, 56MB)
// 테스트 2 〉	통과 (10.48ms, 55MB)
// 테스트 3 〉	통과 (10.52ms, 53.7MB)
// 테스트 4 〉	통과 (9.25ms, 56.3MB)
// 테스트 5 〉	통과 (9.23ms, 53MB)

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        while(i <= j) {
            int sum = people[i] + people[j];
            if(sum > limit) {
                answer++;
                j--;
            } else {
                answer++;
                i++;
                j--;
            }
        }
        return answer;
    }
}
