import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        int idx = 0;
        for (String[] place : places) {
            answer[idx++] = solve(place);
        }
        
        return answer;
    }
    
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};
    
    boolean[][] vis;
    
    public int solve(String[] place) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (place[row].charAt(col) == 'P') {
                    Queue<int[]> q = new LinkedList<>();
                    vis = new boolean[5][5];
                    
                    q.add(new int[] {row, col});
                    vis[row][col] = true;
                    
                    for (int depth = 0; depth < 2; depth++) {
                        int size = q.size();
                        for (int i = 0; i < size; i++) {
                            int[] curr = q.poll();
                            int r = curr[0];
                            int c = curr[1];
                            
                            for (int d = 0; d < 4; d++) {
                                int nr = r + dr[d];
                                int nc = c + dc[d];
                                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5) continue;
                                if (vis[nr][nc]) continue;
                                if (place[nr].charAt(nc) == 'X') continue;
                                if (place[nr].charAt(nc) == 'P') return 0;
                                q.add(new int[] {nr, nc});
                                vis[nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }
        return 1;
    }
}

/*
테스트 1 〉	통과 (0.25ms, 67.6MB)
테스트 2 〉	통과 (0.21ms, 76.1MB)
테스트 3 〉	통과 (0.19ms, 65.5MB)
테스트 4 〉	통과 (0.21ms, 80.5MB)
테스트 5 〉	통과 (0.18ms, 70.5MB)
테스트 6 〉	통과 (0.16ms, 75MB)
테스트 7 〉	통과 (0.21ms, 83.1MB)
테스트 8 〉	통과 (0.25ms, 73.4MB)
테스트 9 〉	통과 (0.18ms, 71.9MB)
테스트 10 〉	통과 (0.20ms, 72.4MB)
테스트 11 〉	통과 (0.19ms, 76.1MB)
테스트 12 〉	통과 (0.20ms, 80.3MB)
테스트 13 〉	통과 (0.14ms, 66.1MB)
테스트 14 〉	통과 (0.20ms, 65.8MB)
테스트 15 〉	통과 (0.21ms, 74.2MB)
테스트 16 〉	통과 (0.19ms, 81.7MB)
테스트 17 〉	통과 (0.20ms, 81.4MB)
테스트 18 〉	통과 (0.23ms, 65.9MB)
테스트 19 〉	통과 (0.14ms, 79.4MB)
테스트 20 〉	통과 (0.20ms, 83.7MB)
테스트 21 〉	통과 (0.19ms, 73.2MB)
테스트 22 〉	통과 (0.22ms, 78.1MB)
테스트 23 〉	통과 (0.03ms, 70.1MB)
테스트 24 〉	통과 (0.16ms, 69.6MB)
테스트 25 〉	통과 (0.04ms, 75.3MB)
테스트 26 〉	통과 (0.03ms, 65.9MB)
테스트 27 〉	통과 (0.44ms, 74.9MB)
테스트 28 〉	통과 (0.22ms, 81.5MB)
테스트 29 〉	통과 (0.27ms, 86.3MB)
테스트 30 〉	통과 (0.17ms, 75MB)
테스트 31 〉	통과 (0.20ms, 81.8MB)
*/
