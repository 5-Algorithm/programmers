class Solution {
    public int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;
        
        int[][] sum = new int[N+1][M+1];
        for(int[] type : skill){
            int r1 = type[1];
            int c1 = type[2];
            int r2 = type[3];
            int c2 = type[4];
            int weight = type[5];
            if(type[0] == 1){
                weight = -weight;
            }
            
            sum[r1][c1] += weight;
            sum[r1][c2+1] -= weight;
            sum[r2+1][c1] -= weight;
            sum[r2+1][c2+1] += weight;
        }
        
        for(int i=0; i<N+1; i++){
            for(int j=0; j<M; j++){
                sum[i][j+1] += sum[i][j];
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M+1; j++){
                sum[i+1][j] += sum[i][j];
            }
        }
        
        int answer = 0;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] + sum[i][j]>0){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.02ms, 77MB)
테스트 2 〉	통과 (0.03ms, 74.9MB)
테스트 3 〉	통과 (0.05ms, 71.6MB)
테스트 4 〉	통과 (0.10ms, 73.3MB)
테스트 5 〉	통과 (0.16ms, 77.1MB)
테스트 6 〉	통과 (0.26ms, 75.7MB)
테스트 7 〉	통과 (0.32ms, 79.7MB)
테스트 8 〉	통과 (0.71ms, 77.3MB)
테스트 9 〉	통과 (0.53ms, 76.9MB)
테스트 10 〉	통과 (0.84ms, 74.8MB)
효율성  테스트
테스트 1 〉	통과 (47.88ms, 212MB)
테스트 2 〉	통과 (48.57ms, 216MB)
테스트 3 〉	통과 (48.03ms, 217MB)
테스트 4 〉	통과 (47.36ms, 212MB)
테스트 5 〉	통과 (44.93ms, 215MB)
테스트 6 〉	통과 (46.92ms, 219MB)
테스트 7 〉	통과 (47.20ms, 217MB)
채점 결과
정확성: 53.8
효율성: 46.2
합계: 100.0 / 100.0
  */
