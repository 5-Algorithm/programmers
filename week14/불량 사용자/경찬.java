/*
정확성  테스트
테스트 1 〉	통과 (0.04ms, 72.2MB)
테스트 2 〉	통과 (0.09ms, 75.8MB)
테스트 3 〉	통과 (0.10ms, 69.1MB)
테스트 4 〉	통과 (0.09ms, 76.9MB)
테스트 5 〉	통과 (11.15ms, 76.8MB)
테스트 6 〉	통과 (1.13ms, 91MB)
테스트 7 〉	통과 (0.06ms, 78.9MB)
테스트 8 〉	통과 (0.06ms, 84.8MB)
테스트 9 〉	통과 (0.07ms, 78.3MB)
테스트 10 〉	통과 (0.06ms, 72.1MB)
테스트 11 〉	통과 (0.13ms, 82MB)
*/

import java.util.*;

class Solution {
    int cnt = 0;
    boolean[] visited;
    Set<Integer> tmp = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        int r = user_id.length;
        int c = banned_id.length;
        visited = new boolean[r];
        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (compare(user_id[i], banned_id[j])) {
                    map[i][j] = 1;
                }
            }
        }
        
        // for (int[] row : map) {
        //     System.out.println(Arrays.toString(row));
        // }
        // System.out.println();
        
        dfs(0, 0, map);
        // for (Set<Integer> row : tmp) {
        //     System.out.println(row);
        // }
        answer = tmp.size();
        return answer;
    }
    
    void dfs(int banIdx, int bit, int[][] map) {
        if (banIdx == map[0].length) {
            tmp.add(bit);
            return;
        }
        
        for (int i = 0; i < map.length; i++) {
            int curr = 1 << i;
            if ((bit & curr) > 0) continue;
            
            if (map[i][banIdx] == 1) {
                bit += curr;
                dfs(banIdx+1, bit, map);
                bit -= curr;
            }
        }
    }
    
    boolean compare(String user_id, String banned_id) {
        if (user_id.length() != banned_id.length()) return false;
        
        for (int i = 0; i < user_id.length(); i++) {
            char ch1 = user_id.charAt(i);
            char ch2 = banned_id.charAt(i);
            if (ch2 == '*') continue;
            if (ch1 != ch2) return false;
        }
        return true;
    }
}

// ----------------------------------------------------
/*
정확성  테스트
테스트 1 〉	통과 (0.10ms, 76.9MB)
테스트 2 〉	통과 (0.37ms, 72MB)
테스트 3 〉	통과 (0.29ms, 73.9MB)
테스트 4 〉	통과 (0.24ms, 70MB)
테스트 5 〉	통과 (105.53ms, 111MB)
테스트 6 〉	통과 (6.04ms, 81.5MB)
테스트 7 〉	통과 (0.15ms, 75.7MB)
테스트 8 〉	통과 (0.27ms, 71.2MB)
테스트 9 〉	통과 (0.37ms, 80.1MB)
테스트 10 〉	통과 (0.11ms, 75.2MB)
테스트 11 〉	통과 (0.67ms, 74.2MB)
*/

import java.util.*;

class Solution {
    int cnt = 0;
    boolean[] visited;
    Set<Set<Integer>> tmp = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        int r = user_id.length;
        int c = banned_id.length;
        visited = new boolean[r];
        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (compare(user_id[i], banned_id[j])) {
                    map[i][j] = 1;
                }
            }
        }
        
        // for (int[] row : map) {
        //     System.out.println(Arrays.toString(row));
        // }
        // System.out.println();
        
        dfs(0, new HashSet<Integer>(), map);
        // for (Set<Integer> row : tmp) {
        //     System.out.println(row);
        // }
        answer = tmp.size();
        return answer;
    }
    
    void dfs(int banIdx, Set<Integer> set, int[][] map) {
        if (banIdx == map[0].length) {
            // if (!tmp.contains(set)) {
            //     System.out.println(set);
            // }
            tmp.add(set);
            return;
        }
        
        for (int i = 0; i < map.length; i++) {
            if (set.contains(i)) continue;
            
            if (map[i][banIdx] == 1) {
                set.add(i);
                dfs(banIdx+1, new HashSet<>(set), map); // 이걸 new로 안하면 틀림
                set.remove(i);
            }
        }
    }
    
    boolean compare(String user_id, String banned_id) {
        if (user_id.length() != banned_id.length()) return false;
        
        for (int i = 0; i < user_id.length(); i++) {
            char ch1 = user_id.charAt(i);
            char ch2 = banned_id.charAt(i);
            if (ch2 == '*') continue;
            if (ch1 != ch2) return false;
        }
        return true;
    }
}
