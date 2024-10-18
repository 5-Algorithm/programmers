// 정확성  테스트
// 테스트 1 〉	통과 (0.78ms, 72.7MB)
// 테스트 2 〉	통과 (1.00ms, 77.9MB)
// 테스트 3 〉	통과 (0.28ms, 73.6MB)
// 테스트 4 〉	통과 (3.80ms, 76.7MB)
// 테스트 5 〉	통과 (0.36ms, 77.1MB)
// 테스트 6 〉	통과 (107.49ms, 74MB)
// 테스트 7 〉	통과 (1.87ms, 71.2MB)
// 테스트 8 〉	통과 (0.87ms, 76.6MB)
// 테스트 9 〉	통과 (2.42ms, 79.9MB)
// 효율성  테스트
// 테스트 1 〉	통과 (31.29ms, 64.9MB)
// 테스트 2 〉	통과 (104.74ms, 72.7MB)
// 테스트 3 〉	통과 (77.66ms, 74.1MB)
// 테스트 4 〉	통과 (33.55ms, 65MB)
// 테스트 5 〉	통과 (80.49ms, 75.6MB)
// 테스트 6 〉	통과 (30.89ms, 63.8MB)

import java.util.*;
import java.io.*;
import java.awt.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int r = land.length;
        int c = land[0].length;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        boolean[][] vis = new boolean[r][c];
        int[][] group = new int[r][c];
        Map<Integer, Integer> map = new HashMap<>();
        
        Queue<Point> queue = new ArrayDeque<>();
        int groupNum = 1;
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(land[i][j] == 1 && !vis[i][j]) {
                    vis[i][j] = true;
                    Point p = new Point(i, j);
                    queue.offer(p);
                    int cnt = 1;
                    groupNum++;
                
                    while(!queue.isEmpty()) {
                        Point curr = queue.poll();
                        int x = curr.x;
                        int y = curr.y;
                        land[x][y] = groupNum;

                        for(int d = 0; d < 4; d++) {
                            int nr = x + dr[d];
                            int nc = y + dc[d];

                            if(nr < 0 || nr >= r || nc < 0 || nc >= c || vis[nr][nc]) continue;
                            if(land[nr][nc] == 1) {
                                vis[nr][nc] = true;
                                Point np = new Point(nr, nc);
                                queue.offer(np);
                                cnt++;
                            }
                        }
                    }
                    map.put(groupNum, cnt);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < c; i++) {
            int count = 0;
            set.clear();
            for(int j = 0; j < r; j++) {
                if(land[j][i] != 0 && !set.contains(land[j][i])) {
                    set.add(land[j][i]);
                    count += map.get(land[j][i]);
                }
            }
            answer = Math.max(count, answer);
        }
        return answer;
    }
}
