/*
정확성  테스트
테스트 1 〉	통과 (0.05ms, 76.6MB)
테스트 2 〉	통과 (0.04ms, 77.2MB)
테스트 3 〉	통과 (0.03ms, 72.4MB)
테스트 4 〉	통과 (0.05ms, 72.8MB)
테스트 5 〉	통과 (0.06ms, 72.5MB)
테스트 6 〉	통과 (0.04ms, 79.3MB)
테스트 7 〉	통과 (0.05ms, 76.7MB)
테스트 8 〉	통과 (0.04ms, 77.1MB)
테스트 9 〉	통과 (0.06ms, 89.3MB)
테스트 10 〉	통과 (0.07ms, 74.2MB)
테스트 11 〉	통과 (0.08ms, 70.8MB)
테스트 12 〉	통과 (0.04ms, 76.4MB)
테스트 13 〉	통과 (0.04ms, 73.4MB)
테스트 14 〉	통과 (0.05ms, 76.4MB)
테스트 15 〉	통과 (0.05ms, 74.1MB)
테스트 16 〉	통과 (0.04ms, 86.5MB)
테스트 17 〉	통과 (0.04ms, 75.7MB)
테스트 18 〉	통과 (0.06ms, 74.6MB)
테스트 19 〉	통과 (0.04ms, 75.7MB)
테스트 20 〉	통과 (0.06ms, 73.5MB)
  */

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int l = words.length;
        
        Set<String> memo = new HashSet<>();
        for (int i = 1; i < l; i++) {
            String prev = words[i-1];
            char prevLast = prev.charAt(prev.length()-1);
            memo.add(prev);
            
            String curr = words[i];
            char currFirst = curr.charAt(0);
            if (prevLast != currFirst || memo.contains(curr)) {
                int remain = i % n;
                int quot = i / n;
                answer[0] = remain + 1;
                answer[1] = quot + 1;
                break;
            }
        }

        return answer;
    }
}
