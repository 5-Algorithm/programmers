import java.util.*;
import java.io.*;

class Car {
    int x;
    int y;
    int dir;
    int cost;
    
    Car(int x, int y, int dir, int cost){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cost = cost;
    }
}

class Solution {
    int[][] visited;
    int n;
    
    public int solution(int[][] board) {
        n = board.length;
        visited = new int[n][n];
        
        int[] dr = {-1, 1,0,0};
        int[] dc = {0,0,-1,1};
        
        Queue<Car> que = new ArrayDeque();
        
        que.add(new Car(0,0,1,100));
        que.add(new Car(0,0,3,100));
        visited[0][0] = 100;
      
        int answer = Integer.MAX_VALUE;
        while(!que.isEmpty()){
            Car cur = que.poll();
            
            if(cur.x == n-1 && cur.y ==n-1){
                answer = Math.min(answer, cur.cost);
                continue;
            }
            
            for(int dir=0; dir<4; dir++){
                int nr = cur.x + dr[dir];
                int nc = cur.y + dc[dir];
                
                if(nr<0 || nc<0 ||nr>n-1 || nc>n-1 || board[nr][nc] ==1) continue;
                
                int weight = 100;
                if(cur.dir != dir) weight = 600;
                
                if(visited[nr][nc] == 0 || cur.cost+weight < visited[nr][nc] + 500){ // 처음 방문하거나 비용이 더 낮은경우
                    visited[nr][nc] = cur.cost+weight;
                    que.add(new Car(nr,nc,dir,cur.cost+weight));
                } 

            }
            
            
        }
        return answer - 100;
    }
}

***
정확성  테스트
테스트 1 〉	통과 (0.24ms, 74.4MB)
테스트 2 〉	통과 (0.22ms, 75.1MB)
테스트 3 〉	통과 (0.32ms, 77.6MB)
테스트 4 〉	통과 (0.27ms, 78MB)
테스트 5 〉	통과 (0.29ms, 74.4MB)
테스트 6 〉	통과 (0.72ms, 76.7MB)
테스트 7 〉	통과 (0.61ms, 76.9MB)
테스트 8 〉	통과 (0.54ms, 72.2MB)
테스트 9 〉	통과 (1.18ms, 78.1MB)
테스트 10 〉	통과 (1.03ms, 75.3MB)
테스트 11 〉	통과 (14.41ms, 77MB)
테스트 12 〉	통과 (1.35ms, 75.5MB)
테스트 13 〉	통과 (0.46ms, 74.6MB)
테스트 14 〉	통과 (0.60ms, 72.1MB)
테스트 15 〉	통과 (1.27ms, 73MB)
테스트 16 〉	통과 (1.27ms, 71.4MB)
테스트 17 〉	통과 (5.97ms, 66.2MB)
테스트 18 〉	통과 (3.61ms, 81.1MB)
테스트 19 〉	통과 (16.25ms, 77.4MB)
테스트 20 〉	통과 (1.72ms, 76MB)
테스트 21 〉	통과 (0.87ms, 71.1MB)
테스트 22 〉	통과 (0.46ms, 78.5MB)
테스트 23 〉	통과 (0.38ms, 78.3MB)
테스트 24 〉	통과 (0.28ms, 79.1MB)
테스트 25 〉	통과 (0.27ms, 74.6MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
***
