import java.util.*;
import java.io.*;

class Solution {
    final int INF = 2000000000;
    public int solution(int[][] board) {
        int answer = INF;
        
        int[] dr = {-1,0,1,0};
        int[] dc = {0,-1,0,1};
        
        // r,c,cost,dir
        Queue<int[]> pq = new ArrayDeque<>();
        
        pq.add(new int[]{0,0,0,2});
        pq.add(new int[]{0,0,0,3});
        
        int[][][] visited=  new int[board.length][board.length][4];
        for(int i = 0 ; i<board.length; i++){
            for(int j = 0; j<board.length; j++)
                Arrays.fill(visited[i][j],INF);
        }
        
        visited[0][0][0] = 0;
        visited[0][0][1] = 0;
        visited[0][0][2] = 0;
        visited[0][0][3] = 0;
      //이거 넣어줬다가 고생좀함 => 0,1이랑 1,0에 벽이있을수도있음
      //pq.add(new int[]{1,0,100,2});
      //pq.add(new int[]{0,1,100,3});
      //visited[1][0][2] = 100;
      //visited[0][1][3] = 100;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            
//             System.out.println(cur[0]+ " "+cur[1]+" "+cur[2] +" "+cur[3]);
            
            // r,c,cost,dir
            for(int i = 0 ; i<4; i++){
                if(Math.abs(i - cur[3]) == 2){
                    continue;
                }
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                int ncost = cur[2] + ((i == cur[3]) ? 100 : 600);
                int ndir = i;
                if(nr < 0 || nc < 0 || nr >= board.length || nc >= board.length)
                    continue;
                
                
                if(visited[nr][nc][ndir] <= ncost)
                    continue;
                
                if(board[nr][nc] == 1)
                    continue;
                
                pq.add(new int[]{nr,nc,ncost,ndir});
                visited[nr][nc][ndir] = ncost;
            }
        }
        
        for(int i = 0 ; i<4; i++){
            answer = Math.min(answer, visited[board.length-1][board.length-1][i]);
        }
        
        return answer;
    }
}
