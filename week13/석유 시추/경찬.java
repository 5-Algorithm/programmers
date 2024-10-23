/*
정확성  테스트
테스트 1 〉	통과 (0.27ms, 71.5MB)
테스트 2 〉	통과 (0.51ms, 71.8MB)
테스트 3 〉	통과 (0.25ms, 76.7MB)
테스트 4 〉	통과 (0.28ms, 78.8MB)
테스트 5 〉	통과 (0.31ms, 78.5MB)
테스트 6 〉	통과 (1.58ms, 72.7MB)
테스트 7 〉	통과 (1.91ms, 75.2MB)
테스트 8 〉	통과 (1.22ms, 73MB)
테스트 9 〉	통과 (5.02ms, 78.7MB)

효율성  테스트
테스트 1 〉	통과 (33.75ms, 68MB)
테스트 2 〉	통과 (159.58ms, 77.4MB)
테스트 3 〉	통과 (143.45ms, 77.5MB)
테스트 4 〉	통과 (26.21ms, 65.6MB)
테스트 5 〉	통과 (123.10ms, 81.2MB)
테스트 6 〉	통과 (39.22ms, 67.4MB)
*/

import java.util.*;

class Solution {
    
    int[] dr = new int[] {1, 0, -1, 0};
    int[] dc = new int[] {0, 1, 0, -1};
    public int solution(int[][] land) {
        int answer = 0;
        int m = land.length;
        int n = land[0].length;
        
        int[][] index = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        int idx = 0;
        Queue<int[]> q = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        ans.add(-1);
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (land[r][c] == 1 && !vis[r][c]) {
                    idx++;
                    q.clear();
                    list.clear();
                    q.add(new int[] {r, c});
                    list.add(new int[] {r, c});
                    vis[r][c] = true;
                    
                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        
                        for (int i = 0; i < 4; i++) {
                            int nr = curr[0] + dr[i];
                            int nc = curr[1] + dc[i];
                            
                            if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                            if (land[nr][nc] == 0 || vis[nr][nc]) continue;
                            
                            q.add(new int[] {nr, nc});
                            list.add(new int[] {nr, nc});
                            vis[nr][nc] = true;
                        }
                    }
                    
                    int size = list.size();
                    for (int[] e : list) {
                        index[e[0]][e[1]] = idx;
                    }
                    ans.add(size);
                }
            }
        }
        
        // for (int[] row : index) {
        //     System.out.println(Arrays.toString(row));
        // }
        // System.out.println(ans);
        
        for (int c = 0; c < n; c++) {
            boolean[] check = new boolean[idx+1];
            int cnt = 0;
            for (int r = 0; r < m; r++) {
                if (index[r][c] == 0) continue;
                check[index[r][c]] = true;
            }
            for (int i = 1; i <= idx; i++) {
                if (check[i]) cnt += ans.get(i);
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
}
