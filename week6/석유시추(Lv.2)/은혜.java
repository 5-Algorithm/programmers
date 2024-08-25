import java.io.*;
import java.util.*;

class Solution {
    
    static class Point {
        int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        int[] arr = new int[m];
        boolean[][] visited = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j] == 0 || visited[i][j]) continue;
                
                
                Queue<Point> que = new LinkedList<>();
                que.add(new Point(i,j));
                visited[i][j] = true;
                
                int[] dr = {-1,0,1,0};
                int[] dc = {0,-1,0,1};
                
                Set<Integer> set = new HashSet<>(); // 석유 덩어리 저장
                int cnt = 1;
                
                while(!que.isEmpty()){
                    Point now = que.poll();
                    set.add(now.y); // 열중복 저장
                    
                    for(int dir=0; dir<4; dir++){
                        int nr = now.x + dr[dir];
                        int nc = now.y + dc[dir];
                        
                        if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
                        
                        if(land[nr][nc] == 1 && !visited[nr][nc]){
                            que.add(new Point(nr,nc));
                            visited[nr][nc] = true;
                            cnt++;
                        }
                    }
                }
                
                for(int num : set){
                    arr[num] += cnt;
                }
            }
        }
        
        int maxNum = 0;
        for(int oil: arr){
            maxNum = Math.max(maxNum, oil);
        }
        
        
        return maxNum;
    }
}
