import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> usedWords = new HashSet<>();
        int turn = 1;
        int player = 1;
        
        usedWords.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            player = (i % n) + 1;
            if (i % n == 0) turn++;
            
            String prevWord = words[i-1];
            String currentWord = words[i];
            

            if (prevWord.charAt(prevWord.length() - 1) != currentWord.charAt(0)) {
                return new int[]{player, turn};
            }
            

            if (usedWords.contains(currentWord)) {
                return new int[]{player, turn};
            }

            
            usedWords.add(currentWord);
        }
        

        return new int[]{0, 0};
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.06ms, 79.7MB)
테스트 2 〉	통과 (0.07ms, 83.9MB)
테스트 3 〉	통과 (0.04ms, 67.4MB)
테스트 4 〉	통과 (0.06ms, 72.5MB)
테스트 5 〉	통과 (0.06ms, 78.9MB)
테스트 6 〉	통과 (0.04ms, 75MB)
테스트 7 〉	통과 (0.06ms, 79.2MB)
테스트 8 〉	통과 (0.05ms, 79MB)
테스트 9 〉	통과 (0.07ms, 72.4MB)
테스트 10 〉	통과 (0.09ms, 72.6MB)
테스트 11 〉	통과 (0.06ms, 65.2MB)
테스트 12 〉	통과 (0.07ms, 82.9MB)
테스트 13 〉	통과 (0.06ms, 71.6MB)
테스트 14 〉	통과 (0.05ms, 74.1MB)
테스트 15 〉	통과 (0.06ms, 74.1MB)
테스트 16 〉	통과 (0.04ms, 75.9MB)
테스트 17 〉	통과 (0.04ms, 74.7MB)
테스트 18 〉	통과 (0.04ms, 71.6MB)
테스트 19 〉	통과 (0.04ms, 78.9MB)
테스트 20 〉	통과 (0.10ms, 74.4MB)
  */
