/*
정확성  테스트
테스트 1 〉	통과 (0.60ms, 71.1MB)
테스트 2 〉	통과 (0.66ms, 72.3MB)
테스트 3 〉	통과 (0.90ms, 77.8MB)
테스트 4 〉	통과 (1.53ms, 74.5MB)
테스트 5 〉	통과 (2.63ms, 76MB)
테스트 6 〉	통과 (5.02ms, 82.4MB)
테스트 7 〉	통과 (8.54ms, 82.3MB)
테스트 8 〉	통과 (33.98ms, 93.1MB)
테스트 9 〉	통과 (1027.01ms, 133MB)
테스트 10 〉 통과 (6457.86ms, 295MB)
*/

import java.util.*;
class Solution {
    public int[] solution(int e, int[] starts) {
        int l = starts.length;
        int[] answer = new int[l];
        
        int[][] dp = new int[e+1][2]; // 약수의 개수
        for (int i = 1; i <= e; i++) {
            dp[i][0] = i;
            for (int j = i; j <= e; j += i) {
                dp[j][1]++;
            }
        }
        
        Arrays.sort(dp, (o1, o2) -> {
            if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
            return Integer.compare(o2[1], o1[1]);
        });
        
        // for (int[] row : dp) {
        //     System.out.println(Arrays.toString(row));
        // }
        
        for (int i = 0; i < l; i++) {
            int s = starts[i];
            
            for (int[] row : dp) {
                if (s <= row[0]) {
                    answer[i] = row[0];
                    break;
                }
            }
        }
        return answer;
    }
}
