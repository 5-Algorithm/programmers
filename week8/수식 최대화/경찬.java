/*
정확성  테스트
테스트 1 〉	통과 (0.39ms, 79.1MB)
테스트 2 〉	통과 (0.39ms, 77MB)
테스트 3 〉	통과 (0.46ms, 82.9MB)
테스트 4 〉	통과 (0.87ms, 86.5MB)
테스트 5 〉	통과 (1.06ms, 78.3MB)
테스트 6 〉	통과 (0.75ms, 76.6MB)
테스트 7 〉	통과 (0.73ms, 70.6MB)
테스트 8 〉	통과 (1.05ms, 76MB)
테스트 9 〉	통과 (1.55ms, 78.5MB)
테스트 10 〉	통과 (1.33ms, 72.8MB)
테스트 11 〉	통과 (0.95ms, 73.4MB)
테스트 12 〉	통과 (1.47ms, 78.1MB)
테스트 13 〉	통과 (1.60ms, 74.7MB)
테스트 14 〉	통과 (1.89ms, 71.2MB)
테스트 15 〉	통과 (1.77ms, 76.4MB)
테스트 16 〉	통과 (0.70ms, 76.6MB)
테스트 17 〉	통과 (0.44ms, 74.1MB)
테스트 18 〉	통과 (0.58ms, 77MB)
테스트 19 〉	통과 (0.39ms, 83.4MB)
테스트 20 〉	통과 (0.48ms, 72.6MB)
테스트 21 〉	통과 (1.86ms, 72.4MB)
테스트 22 〉	통과 (1.52ms, 74MB)
테스트 23 〉	통과 (0.42ms, 77.6MB)
테스트 24 〉	통과 (1.38ms, 69.4MB)
테스트 25 〉	통과 (1.60ms, 67.3MB)
테스트 26 〉	통과 (0.36ms, 76.2MB)
테스트 27 〉	통과 (2.04ms, 72.6MB)
테스트 28 〉	통과 (1.74ms, 71.4MB)
테스트 29 〉	통과 (1.40ms, 74.2MB)
테스트 30 〉	통과 (1.50ms, 76.8MB)
*/

import java.util.*;

class Solution {
    
    char[][] op = {{'*', '+', '-'},
                   {'*', '-', '+'},
                   {'+', '*', '-'},
                   {'+', '-', '*'},
                   {'-', '*', '+'},
                   {'-', '+', '*'}};
    
    public long solution(String expression) {
        long answer = 0;
        int l = expression.length();
        
        int idx = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            char ch = expression.charAt(i);
            if (ch == '*' || ch == '+' || ch == '-') {
                list.add(expression.substring(idx, i));
                list.add(Character.toString(ch));
                idx = i + 1;
            }
        }
        list.add(expression.substring(idx, l));
        
        Deque<String> q = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            for (String s : list) {
                q.add(s);
            }
            
            for (int j = 0; j < 3; j++) {
                char operator = op[i][j];
                
                int size = q.size();
                for (int k = 0; k < size; k++) {
                    String curr = q.pollFirst();
                    
                    if (curr.equals(Character.toString(operator))) {
                        long tmp = 0;
                        if(curr.equals("*")) {
                            tmp = Long.parseLong(q.pollLast()) * Long.parseLong(q.pollFirst());
                        } else if (curr.equals("+")) {
                            tmp = Long.parseLong(q.pollLast()) + Long.parseLong(q.pollFirst());
                        } else if (curr.equals("-")) {
                            tmp = Long.parseLong(q.pollLast()) - Long.parseLong(q.pollFirst());
                        }
                        
                        q.offerLast(String.valueOf(tmp));
                        k++;
                    } else {
                        q.offerLast(curr);
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(q.poll())));
        }
        return answer;
    }
    
}
