class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] divcnt = new int[e+1]; // 약수 
        int[] freq = new int[e+1]; // 범위 별 답 
        int maxdiv = e; // 현재 가장 많은 약수를 갖고 있는 수 
        
        for(int i = 1; i<= e; i++)
            divcnt[i] = 1;
        
        for(int i = 2;i<=e ; i++){
            for(int j = 1; ; j++){
                if(i * j > e) break;
                divcnt[i*j]++;
            }
        }
        
        for(int i = e; i>0; i--){
            if(divcnt[i] >= divcnt[maxdiv])
                maxdiv = i;
            freq[i] = maxdiv;
        }
      
        
        for(int i = 0; i<answer.length; i++)
            answer[i] = freq[starts[i]];
        
        return answer;
    }
}


// 테스트 1 〉	통과 (0.01ms, 75.7MB)
// 테스트 2 〉	통과 (0.01ms, 73.7MB)
// 테스트 3 〉	통과 (0.05ms, 76.4MB)
// 테스트 4 〉	통과 (0.14ms, 73.1MB)
// 테스트 5 〉	통과 (0.19ms, 77.3MB)
// 테스트 6 〉	통과 (1.78ms, 79.3MB)
// 테스트 7 〉	통과 (3.51ms, 73.6MB)
// 테스트 8 〉	통과 (8.61ms, 83.8MB)
// 테스트 9 〉	통과 (53.70ms, 103MB)
// 테스트 10 〉	통과 (295.92ms, 147MB)
