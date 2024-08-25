import java.util.*;

class Solution {
    boolean[][] vis;
    int n, m;
    Map<Integer, Integer> map = new HashMap<>();
    
    public int solution(int[][] land) {
        int answer = 0;
        
        n = land.length;
        m = land[0].length;
        
        for (int col = 0; col < m; col++) {
            map.put(col, 0);
        }
        
        vis = new boolean[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (vis[r][c]) continue;
                if (land[r][c] == 0) continue;
                BFS(r, c, land);
            }
        }
        
        for (int col = 0; col < m; col++) {
            answer = Math.max(answer, map.get(col));
        }
        
        return answer;
    }
    
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};
    
    public void BFS(int row, int col, int[][] land) {
        int cnt = 0;
        Queue<Integer[]> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.add(new Integer[] {row, col});
        vis[row][col] = true;
        cnt++;
        set.add(col);
        
        while (!q.isEmpty()) {
            Integer[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (land[nr][nc] == 0) continue;
                if (vis[nr][nc]) continue;
                q.add(new Integer[] {nr, nc});
                vis[nr][nc] = true;
                cnt++;
                set.add(nc);
            }
        }
        
        for (int idx : set) {
            map.put(idx, map.get(idx) + cnt);
        }
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.26ms, 75.2MB)
테스트 2 〉	통과 (0.43ms, 78MB)
테스트 3 〉	통과 (0.41ms, 74.4MB)
테스트 4 〉	통과 (0.26ms, 73MB)
테스트 5 〉	통과 (0.41ms, 83.7MB)
테스트 6 〉	통과 (1.22ms, 74.1MB)
테스트 7 〉	통과 (1.79ms, 73.9MB)
테스트 8 〉	통과 (0.64ms, 76.5MB)
테스트 9 〉	통과 (2.63ms, 77.7MB)

효율성  테스트
테스트 1 〉	통과 (31.52ms, 63.5MB)
테스트 2 〉	통과 (84.30ms, 76.5MB)
테스트 3 〉	통과 (66.33ms, 75.9MB)
*/
