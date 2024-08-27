import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int n = people.length;
        PriorityQueue<Integer> light = new PriorityQueue<>();
        PriorityQueue<Integer> heavy = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o2, o1));
        int mean = limit / 2;
        for (int i = 0; i < n; i++) {
            if (people[i] > mean) heavy.add(people[i]);
            else light.add(people[i]);
        }
        
        while (!heavy.isEmpty()) {
            int curr = heavy.poll();
            if (!light.isEmpty() && light.peek() + curr <= limit) {
                light.poll();
            }
            answer++;
        }
        
        
        int size = light.size();
        answer += size / 2;
        if (size % 2 != 0) answer++;
        
        return answer;
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (7.20ms, 75MB)
테스트 2 〉	통과 (3.50ms, 74.4MB)
테스트 3 〉	통과 (5.81ms, 79.1MB)
테스트 4 〉	통과 (5.43ms, 77.8MB)
테스트 5 〉	통과 (3.37ms, 74.9MB)
테스트 6 〉	통과 (2.86ms, 78.8MB)
테스트 7 〉	통과 (4.22ms, 77.2MB)
테스트 8 〉	통과 (1.62ms, 79.4MB)
테스트 9 〉	통과 (1.79ms, 73.2MB)
테스트 10 〉	통과 (4.81ms, 76.1MB)
테스트 11 〉	통과 (3.88ms, 74.5MB)
테스트 12 〉	통과 (5.06ms, 83.4MB)
테스트 13 〉	통과 (5.75ms, 74.3MB)
테스트 14 〉	통과 (4.17ms, 79.1MB)
테스트 15 〉	통과 (1.86ms, 76.1MB)
테스트 16 〉	통과 (0.69ms, 74.4MB)
테스트 17 〉	통과 (0.74ms, 83.5MB)
테스트 18 〉	통과 (0.76ms, 76.9MB)
테스트 19 〉	통과 (0.74ms, 73.7MB)
테스트 20 〉	통과 (0.74ms, 77.7MB)
테스트 21 〉	통과 (0.69ms, 78.9MB)
테스트 22 〉	통과 (0.70ms, 70.9MB)

효율성  테스트
테스트 1 〉	통과 (39.14ms, 56.5MB)
테스트 2 〉	통과 (41.48ms, 54.4MB)
테스트 3 〉	통과 (50.62ms, 55MB)
테스트 4 〉	통과 (53.26ms, 74.5MB)
테스트 5 〉	통과 (30.23ms, 54MB)
*/
