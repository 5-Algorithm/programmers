// 정확성  테스트
// 테스트 1 〉	통과 (0.27ms, 79.2MB)
// 테스트 2 〉	통과 (0.31ms, 73.3MB)
// 테스트 3 〉	통과 (0.78ms, 73.2MB)
// 테스트 4 〉	통과 (0.81ms, 82.4MB)
// 테스트 5 〉	통과 (0.06ms, 70.7MB)
// 테스트 6 〉	통과 (0.17ms, 77.4MB)
// 테스트 7 〉	통과 (0.25ms, 84.2MB)
// 테스트 8 〉	통과 (0.88ms, 79.2MB)
// 테스트 9 〉	통과 (2.24ms, 74.4MB)
// 테스트 10 〉	통과 (0.80ms, 88.6MB)
// 테스트 11 〉	통과 (1.13ms, 76.9MB)
// 테스트 12 〉	통과 (1.66ms, 96.8MB)
// 테스트 13 〉	통과 (1.66ms, 78.3MB)
// 테스트 14 〉	통과 (1.64ms, 79.7MB)
// 테스트 15 〉	통과 (3.27ms, 80.4MB)
// 효율성  테스트
// 테스트 1 〉	통과 (6.90ms, 54.4MB)
// 테스트 2 〉	통과 (6.66ms, 56.6MB)
// 테스트 3 〉	통과 (14.94ms, 57.4MB)
// 테스트 4 〉	통과 (14.71ms, 63.2MB)
// 테스트 5 〉	통과 (18.99ms, 62.1MB)
// 테스트 6 〉	통과 (22.61ms, 63MB)
// 테스트 7 〉	통과 (24.13ms, 64.9MB)
// 테스트 8 〉	통과 (27.58ms, 68.4MB)
// 테스트 9 〉	통과 (30.49ms, 70MB)
// 테스트 10 〉	통과 (29.39ms, 75.3MB)
// 테스트 11 〉	통과 (41.41ms, 78.8MB)
// 테스트 12 〉	통과 (49.60ms, 78.7MB)
// 테스트 13 〉	통과 (42.56ms, 80.2MB)
// 테스트 14 〉	통과 (38.60ms, 80.5MB)
// 테스트 15 〉	통과 (50.55ms, 80.9MB)

import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int n = gems.length;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(gems[i]);
        }
        int gemCnt = set.size();
        if(gemCnt == 1) {
            answer[0] = 1;
            answer[1] = 1;
            return answer;
        }
        
        Map<String, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int minSize = 987654321;
        map.put(gems[left], 1);
        System.out.println(gemCnt);
        
        while(right < n) {
            if(map.size() < gemCnt) {
                if(++right == n) break;
                int cnt = map.getOrDefault(gems[right], 0);
                map.put(gems[right], cnt + 1);
            } else {
                int cnt = map.get(gems[left]);
                if(cnt == 1) {
                    map.remove(gems[left]);
                } else {
                    map.put(gems[left], cnt - 1);
                }
                left++;
            }
            
            if(map.size() == gemCnt && minSize > (right - left)) {
                minSize = right - left;
                answer[0] = left + 1;
                answer[1] = right + 1;
            }
        }
        return answer;
    }
}
