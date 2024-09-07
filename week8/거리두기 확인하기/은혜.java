import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);
        
        for (int t = 0; t < places.length; t++) {
            if (!checkPlace(places[t])) {
                answer[t] = 0;
            }
        }
        return answer;
    }
    
    private boolean checkPlace(String[] place) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P') {
                    
                    Queue<int[]> queue=new ArrayDeque<>();
                    boolean[][] visited = new boolean[5][5];
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                    
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int curR = cur[0], curC = cur[1], dist = cur[2];
                        
                        if (dist>2) continue;
                        
                        for (int dir = 0; dir < 4; dir++) {
                            int nr = curR + dr[dir];
                            int nc = curC + dc[dir];
                            
                            if (nr<0 || nr>4 || nc<0 || nc>4 || visited[nr][nc]) continue;
                            
                            if (place[nr].charAt(nc) == 'P' && dist < 2) return false;
                            if (place[nr].charAt(nc) == 'O' && dist < 1) {
                                queue.offer(new int[]{nr, nc, dist + 1});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}

/*
테스트 1 〉	통과 (0.14ms, 74.2MB)
테스트 2 〉	통과 (0.08ms, 84MB)
테스트 3 〉	통과 (0.08ms, 73.1MB)
테스트 4 〉	통과 (0.09ms, 73.9MB)
테스트 5 〉	통과 (0.06ms, 73MB)
테스트 6 〉	통과 (0.12ms, 71.1MB)
테스트 7 〉	통과 (0.07ms, 77.9MB)
테스트 8 〉	통과 (0.11ms, 73.6MB)
테스트 9 〉	통과 (0.12ms, 75.5MB)
테스트 10 〉	통과 (0.06ms, 81.5MB)
테스트 11 〉	통과 (0.12ms, 74MB)
테스트 12 〉	통과 (0.07ms, 82.5MB)
테스트 13 〉	통과 (0.10ms, 78.3MB)
테스트 14 〉	통과 (0.06ms, 75.3MB)
테스트 15 〉	통과 (0.07ms, 92.4MB)
테스트 16 〉	통과 (0.08ms, 72.3MB)
테스트 17 〉	통과 (0.08ms, 65.7MB)
테스트 18 〉	통과 (0.08ms, 72.4MB)
테스트 19 〉	통과 (0.11ms, 78.5MB)
테스트 20 〉	통과 (0.09ms, 77.2MB)
테스트 21 〉	통과 (0.08ms, 74.1MB)
테스트 22 〉	통과 (0.07ms, 72.2MB)
테스트 23 〉	통과 (0.03ms, 74.5MB)
테스트 24 〉	통과 (0.05ms, 76.2MB)
테스트 25 〉	통과 (0.03ms, 76.9MB)
테스트 26 〉	통과 (0.02ms, 77.1MB)
테스트 27 〉	통과 (0.06ms, 76.6MB)
테스트 28 〉	통과 (0.08ms, 73.6MB)
테스트 29 〉	통과 (0.07ms, 76.6MB)
테스트 30 〉	통과 (0.06ms, 73MB)
테스트 31 〉	통과 (0.08ms, 73.5MB)
  */
