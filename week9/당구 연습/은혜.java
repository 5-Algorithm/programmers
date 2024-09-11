class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        
        int[] answer = new int[balls.length];
        
        for(int i=0; i<balls.length; i++){
            int targetX = balls[i][0];
            int targetY = balls[i][1];
            
            int cur = 0;
            int result = Integer.MAX_VALUE;
            
            // 당구대의 상,하,좌,우 로 이동했을때 경우로 나눠서 풀이
            
            // 상 -> 시작공과 타겟공이 먼저 부딪히는 경우를 제외
            if(!(startX == targetX && startY <= targetY)){
                cur = dist(startX, startY, targetX, n+(n-targetY));
                result = Math.min(cur, result);
            }
            
            // 하
            if (!(startX == targetX && startY >= targetY)) {
                cur = dist(startX, startY, targetX, targetY * (-1));
                result = Math.min(cur, result);
            }
            
            // 좌
            if (!(startY == targetY && startX >= targetX)) {
                cur = dist(startX, startY, targetX * (-1), targetY);
                result = Math.min(cur, result);
            }
            
            // 우
            if (!(startY == targetY && startX <= targetX)) {
                cur = dist(startX, startY, m + (m - targetX), targetY);
                result = Math.min(cur, result);
            }
            
            answer[i] = result;
            
            
        }
        return answer;
    }
    
    public int dist(int sx, int sy, int tx, int ty){
        return (int) (Math.pow(sx-tx,2) + Math.pow(sy-ty,2));
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.68ms, 87.1MB)
테스트 2 〉	통과 (0.57ms, 75.7MB)
테스트 3 〉	통과 (0.14ms, 81.3MB)
테스트 4 〉	통과 (0.44ms, 71.7MB)
테스트 5 〉	통과 (0.17ms, 75MB)
테스트 6 〉	통과 (0.48ms, 74.3MB)
테스트 7 〉	통과 (0.54ms, 79.5MB)
테스트 8 〉	통과 (0.17ms, 78.6MB)
테스트 9 〉	통과 (0.23ms, 77.4MB)
테스트 10 〉	통과 (0.46ms, 80.6MB)
테스트 11 〉	통과 (0.57ms, 76.6MB)
테스트 12 〉	통과 (0.39ms, 75.4MB)
테스트 13 〉	통과 (0.70ms, 66.9MB)
테스트 14 〉	통과 (0.06ms, 78.2MB)
테스트 15 〉	통과 (0.39ms, 79MB)
테스트 16 〉	통과 (0.46ms, 73MB)
테스트 17 〉	통과 (0.22ms, 80.5MB)
테스트 18 〉	통과 (0.41ms, 77.7MB)
테스트 19 〉	통과 (0.45ms, 78.1MB)
테스트 20 〉	통과 (0.46ms, 79.9MB)
테스트 21 〉	통과 (0.61ms, 74.4MB)
테스트 22 〉	통과 (0.27ms, 79.1MB)
테스트 23 〉	통과 (0.34ms, 79.2MB)
테스트 24 〉	통과 (0.32ms, 76.8MB)
테스트 25 〉	통과 (0.41ms, 79.4MB)
테스트 26 〉	통과 (0.34ms, 71.6MB)
테스트 27 〉	통과 (0.14ms, 78.9MB)
테스트 28 〉	통과 (0.32ms, 77.1MB)
테스트 29 〉	통과 (0.04ms, 78MB)
테스트 30 〉	통과 (0.04ms, 73.1MB)
테스트 31 〉	통과 (0.46ms, 79.2MB)
테스트 32 〉	통과 (0.65ms, 77.5MB)
테스트 33 〉	통과 (0.08ms, 73MB)
테스트 34 〉	통과 (0.75ms, 74.9MB)
테스트 35 〉	통과 (0.07ms, 77.2MB)
테스트 36 〉	통과 (0.48ms, 75.5MB)
  */
