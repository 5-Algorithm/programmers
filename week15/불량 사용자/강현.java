// 정확성  테스트
// 테스트 1 〉	통과 (11.34ms, 73.4MB)
// 테스트 2 〉	통과 (10.25ms, 77MB)
// 테스트 3 〉	통과 (12.36ms, 83.1MB)
// 테스트 4 〉	통과 (14.45ms, 77.2MB)
// 테스트 5 〉	통과 (79.35ms, 104MB)
// 테스트 6 〉	통과 (19.31ms, 76.1MB)
// 테스트 7 〉	통과 (11.18ms, 78.7MB)
// 테스트 8 〉	통과 (10.48ms, 79.1MB)
// 테스트 9 〉	통과 (10.04ms, 77MB)
// 테스트 10 〉	통과 (12.72ms, 76.9MB)
// 테스트 11 〉	통과 (10.65ms, 76MB)

import java.io.*;
import java.util.*;

class Solution {
    static int n, m, answer;
    static Set<String> set;
    static Set<String> answerSet;
    static boolean[] vis;
    static String[] userId, bannedId;
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        n = banned_id.length;
        m = user_id.length;
        userId = user_id;
        bannedId = banned_id;
        set = new HashSet<>();
        answerSet = new HashSet<>();
        vis = new boolean[m];
        backtracking(0);
        return answer;
    }
    
    static void backtracking(int depth) {
        if(depth == n) {
            String s = "";
            for(int i = 0; i < m; i++) {
                if(vis[i]) s += i;
            }
            if(!answerSet.contains(s)) {
                System.out.println(s);
                answerSet.add(s);
                answer++;
            }
            return;
        }
    
        String compare = bannedId[depth];
        for(int i = 0; i < m; i++) {
            if(vis[i]) continue;
            String curr = userId[i];
            if(set.contains(curr)) continue;
            if(curr.length() != compare.length()) continue;
            for(int j = 0; j < curr.length(); j++) {
                char c = curr.charAt(j);
                char comC = compare.charAt(j);
                if(comC != '*' && c != comC) {
                    break;
                }
                if(j == curr.length() - 1) {
                    vis[i] = true;
                    backtracking(depth + 1);
                    vis[i] = false;
                }
            }
        }
    }
}
