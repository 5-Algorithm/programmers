// 테스트 1 〉	통과 (0.04ms, 75MB)
// 테스트 2 〉	통과 (0.07ms, 76.9MB)
// 테스트 3 〉	통과 (0.04ms, 78.1MB)
// 테스트 4 〉	통과 (0.06ms, 76.8MB)
// 테스트 5 〉	통과 (0.07ms, 74.3MB)
// 테스트 6 〉	통과 (0.04ms, 75.8MB)
// 테스트 7 〉	통과 (0.06ms, 71.4MB)
// 테스트 8 〉	통과 (0.04ms, 78.2MB)
// 테스트 9 〉	통과 (0.06ms, 77.7MB)
// 테스트 10 〉	통과 (0.09ms, 76.3MB)
// 테스트 11 〉	통과 (0.13ms, 79.1MB)
// 테스트 12 〉	통과 (0.06ms, 74.8MB)
// 테스트 13 〉	통과 (0.04ms, 77.1MB)
// 테스트 14 〉	통과 (0.13ms, 78.6MB)
// 테스트 15 〉	통과 (0.04ms, 79.2MB)
// 테스트 16 〉	통과 (0.04ms, 74.9MB)
// 테스트 17 〉	통과 (0.04ms, 73.1MB)
// 테스트 18 〉	통과 (0.07ms, 77MB)
// 테스트 19 〉	통과 (0.03ms, 72.9MB)
// 테스트 20 〉	통과 (0.07ms, 77.4MB)

import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[] {0, 0};
        int turn = 1;
        int idx = 0;
        String prev = null;
        Set<String> set = new HashSet<>();
        
        a: while(idx < words.length) {
            for(int i = 1; i <= n; i++) {
                String curr = words[idx++];
                if(prev != null && prev.charAt(prev.length() - 1) != curr.charAt(0)) {
                    answer[0] = i;
                    answer[1] = turn;
                    break a;
                }
                
                if(set.contains(curr) || curr.length() == 1) {
                    answer[0] = i;
                    answer[1] = turn;
                    break a;
                }
                
                set.add(curr);
                prev = curr;
                if(idx >= words.length) break a;
            }
            turn++;
        }

        return answer;
    }
}
