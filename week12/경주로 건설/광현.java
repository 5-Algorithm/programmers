//pq 안쓴 버전

// 테스트 1 〉	통과 (0.14ms, 72.7MB)
// 테스트 2 〉	통과 (0.06ms, 75.6MB)
// 테스트 3 〉	통과 (0.12ms, 76.4MB)
// 테스트 4 〉	통과 (0.11ms, 72.3MB)
// 테스트 5 〉	통과 (0.16ms, 79.7MB)
// 테스트 6 〉	통과 (1.20ms, 85.3MB)
// 테스트 7 〉	통과 (1.22ms, 78.3MB)
// 테스트 8 〉	통과 (1.26ms, 70.7MB)
// 테스트 9 〉	통과 (1.06ms, 71.6MB)
// 테스트 10 〉	통과 (1.43ms, 76.7MB)
// 테스트 11 〉	통과 (10.09ms, 74.6MB)
// 테스트 12 〉	통과 (2.99ms, 74.7MB)
// 테스트 13 〉	통과 (0.58ms, 81MB)
// 테스트 14 〉	통과 (0.62ms, 74.8MB)
// 테스트 15 〉	통과 (1.72ms, 75MB)
// 테스트 16 〉	통과 (1.29ms, 81.5MB)
// 테스트 17 〉	통과 (3.30ms, 78MB)
// 테스트 18 〉	통과 (3.54ms, 74.3MB)
// 테스트 19 〉	통과 (8.44ms, 76.4MB)
// 테스트 20 〉	통과 (2.21ms, 78.2MB)
// 테스트 21 〉	통과 (2.40ms, 85.3MB)
// 테스트 22 〉	통과 (0.27ms, 80MB)
// 테스트 23 〉	통과 (0.18ms, 74.1MB)
// 테스트 24 〉	통과 (0.19ms, 73.3MB)
// 테스트 25 〉	통과 (0.70ms, 77.1MB)

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


// pq쓴 버전

// 테스트 1 〉	통과 (0.71ms, 76.4MB)
// 테스트 2 〉	통과 (0.47ms, 73.6MB)
// 테스트 3 〉	통과 (0.70ms, 75MB)
// 테스트 4 〉	통과 (0.51ms, 73.5MB)
// 테스트 5 〉	통과 (0.72ms, 84.3MB)
// 테스트 6 〉	통과 (0.91ms, 76.1MB)
// 테스트 7 〉	통과 (1.46ms, 75.3MB)
// 테스트 8 〉	통과 (1.27ms, 75.8MB)
// 테스트 9 〉	통과 (0.98ms, 70.9MB)
// 테스트 10 〉	통과 (2.06ms, 73.8MB)
// 테스트 11 〉	통과 (3.36ms, 79.5MB)
// 테스트 12 〉	통과 (5.94ms, 72.2MB)
// 테스트 13 〉	통과 (0.71ms, 74.5MB)
// 테스트 14 〉	통과 (1.24ms, 75.2MB)
// 테스트 15 〉	통과 (2.24ms, 73.3MB)
// 테스트 16 〉	통과 (2.21ms, 79.9MB)
// 테스트 17 〉	통과 (2.27ms, 78.4MB)
// 테스트 18 〉	통과 (2.32ms, 72.3MB)
// 테스트 19 〉	통과 (1.93ms, 76.1MB)
// 테스트 20 〉	통과 (1.75ms, 80.3MB)
// 테스트 21 〉	통과 (2.72ms, 70.5MB)
// 테스트 22 〉	통과 (0.79ms, 78.4MB)
// 테스트 23 〉	통과 (0.57ms, 69.8MB)
// 테스트 24 〉	통과 (0.70ms, 68.1MB)
// 테스트 25 〉	통과 (0.76ms, 78.2MB)

import java.util.*;
import java.io.*;

class Solution {
    final int INF = 2000000000;
    public int solution(int[][] board) {
        int answer = INF;
        
        int[] dr = {-1,0,1,0};
        int[] dc = {0,-1,0,1};
        
        // r,c,cost,dir
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[2] - o2[2];
            }
        });
        
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
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            
//             System.out.println(cur[0]+ " "+cur[1]+" "+cur[2] +" "+cur[3]);
            if(cur[0] == board.length-1 && cur[1] == board.length-1){
                answer = cur[2];
                break;
            }
            
            
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
        
        
        return answer;
    }
}
