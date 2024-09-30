// 정확성  테스트
// 테스트 1 〉	통과 (0.05ms, 82MB)
// 테스트 2 〉	통과 (0.05ms, 74MB)
// 테스트 3 〉	통과 (0.24ms, 72.7MB)
// 테스트 4 〉	통과 (0.48ms, 74.1MB)
// 테스트 5 〉	통과 (0.91ms, 78MB)
// 테스트 6 〉	통과 (0.62ms, 71.5MB)
// 테스트 7 〉	통과 (2.41ms, 69.9MB)
// 테스트 8 〉	통과 (1.24ms, 76.9MB)
// 테스트 9 〉	통과 (9.45ms, 84.4MB)
// 테스트 10 〉	통과 (4.60ms, 75.7MB)
// 테스트 11 〉	통과 (31.03ms, 87MB)
// 테스트 12 〉	통과 (13.42ms, 83.8MB)
// 테스트 13 〉	통과 (42.73ms, 91.5MB)
// 테스트 14 〉	통과 (38.10ms, 83.4MB)
// 테스트 15 〉	통과 (6.31ms, 79.2MB)
// 테스트 16 〉	통과 (6.14ms, 77.9MB)
// 테스트 17 〉	통과 (0.13ms, 64.2MB)
// 테스트 18 〉	통과 (2.14ms, 85.2MB)
// 테스트 19 〉	통과 (0.04ms, 76.6MB)
// 테스트 20 〉	통과 (0.04ms, 79MB)

import java.io.*;
import java.util.*;

class Solution {
    
    static int n;
    static int[] answer, discount, price, emoticon;
    static int[][] user;
    
    public int[] solution(int[][] users, int[] emoticons) {
        n = emoticons.length;
        answer = new int[2];
        discount = new int[n];
        price = new int[n];
        emoticon = emoticons;
        user = users;
        
        backtracking(0);
        
        return answer;
    }
    
    static void backtracking(int depth) {
        if(depth == n) {
            for(int i = 0; i < n; i++) {
                price[i] = emoticon[i] * (100 - discount[i]) / 100;
            }

            int sumPrice = 0;
            int cnt = 0;
            for(int i = 0; i < user.length; i++) {
                int sum = 0;
                for(int j = 0; j < n; j++) {
                    if(discount[j] >= user[i][0]) sum += price[j];
                }
                if(sum >= user[i][1]) cnt++;
                else sumPrice += sum;
            }
            if(answer[0] < cnt) {
                answer[0] = cnt;
                answer[1] = sumPrice;
            } else if(answer[0] == cnt) {
                answer[1] = Math.max(sumPrice, answer[1]);
            }
            return;
        }
        
        for(int i = 10; i <= 40; i += 10) {
            discount[depth] = i;
            backtracking(depth + 1);
        }
    }
}
