import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer,1);
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        for(int k = 0 ; k < places.length; k++){
            Queue<int[]> queue = new ArrayDeque<>();
            char[][] map = new char[5][5];
            int[][] dist = new int[5][5];
            for(int i = 0; i <5; i++){
                for(int j = 0; j<5; j++){
                    dist[i][j] = -1;
                    map[i][j] =places[k][i].charAt(j);
                    if(places[k][i].charAt(j) == 'P'){
                        queue.add(new int[]{i,j});
                        dist[i][j] = 0;
                    }
                   
                }
            }
            
            out : while(!queue.isEmpty()){
                int[] cur = queue.poll();
                
                for(int i = 0 ; i<4 ; i++){
                    int nr = cur[0]+dr[i];
                    int nc = cur[1]+dc[i];
                    if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || map[nr][nc] == 'X')
                        continue;
                    
                    if(dist[nr][nc] != -1){
                        answer[k] = 0;
                        break out;
                    }
                    else{
                        dist[nr][nc] = 1;
                    }
                }
            }
        }
        
        return answer;
    }
}
