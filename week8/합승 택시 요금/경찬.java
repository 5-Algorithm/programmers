/*
정확성  테스트
테스트 1 〉	통과 (0.96ms, 75.5MB)
테스트 2 〉	통과 (0.96ms, 77.3MB)
테스트 3 〉	통과 (0.83ms, 70.1MB)
테스트 4 〉	통과 (1.76ms, 89.3MB)
테스트 5 〉	통과 (1.36ms, 78.1MB)
테스트 6 〉	통과 (1.35ms, 80.4MB)
테스트 7 〉	통과 (1.81ms, 73.9MB)
테스트 8 〉	통과 (2.31ms, 74.9MB)
테스트 9 〉	통과 (2.15ms, 75MB)
테스트 10 〉	통과 (1.94ms, 82.6MB)

효율성  테스트
테스트 1 〉	통과 (27.01ms, 55.1MB)
테스트 2 〉	통과 (75.58ms, 60.9MB)
테스트 3 〉	통과 (39.19ms, 55.5MB)
테스트 4 〉	통과 (34.58ms, 56.6MB)
테스트 5 〉	통과 (36.93ms, 55.4MB)
테스트 6 〉	통과 (32.16ms, 56.9MB)
테스트 7 〉	통과 (191.82ms, 75.8MB)
테스트 8 〉	통과 (175.45ms, 73MB)
테스트 9 〉	통과 (126.34ms, 68.2MB)
테스트 10 〉	통과 (127.26ms, 68.5MB)
테스트 11 〉	통과 (136.87ms, 68.8MB)
테스트 12 〉	통과 (114.92ms, 67.5MB)
테스트 13 〉	통과 (115.02ms, 67.4MB)
테스트 14 〉	통과 (112.35ms, 65.4MB)
테스트 15 〉	통과 (125.30ms, 67.7MB)
테스트 16 〉	통과 (29.54ms, 56.4MB)
테스트 17 〉	통과 (27.83ms, 55.7MB)
테스트 18 〉	통과 (28.99ms, 55.3MB)
테스트 19 〉	통과 (51.44ms, 58.5MB)
테스트 20 〉	통과 (75.80ms, 61.1MB)
테스트 21 〉	통과 (83.25ms, 61.6MB)
테스트 22 〉	통과 (118.83ms, 67.6MB)
테스트 23 〉	통과 (114.86ms, 70.9MB)
테스트 24 〉	통과 (119.50ms, 67.5MB)
테스트 25 〉	통과 (28.88ms, 69.6MB)
테스트 26 〉	통과 (26.47ms, 54.5MB)
테스트 27 〉	통과 (78.35ms, 61.7MB)
테스트 28 〉	통과 (90.41ms, 60.7MB)
테스트 29 〉	통과 (17.15ms, 53.1MB)
테스트 30 〉	통과 (17.57ms, 53.5MB)
*/

import java.util.*;

class Solution {
    
    int MAX_VALUE = 987654321;
    
    class Edge implements Comparable<Edge> {
        int idx, weight;
        
        public Edge() {}
        public Edge(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    
    List<Edge>[] adj;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge : fares) {
            int from = edge[0];
            int to = edge[1];
            int c = edge[2];
            
            adj[from].add(new Edge(to, c));
            adj[to].add(new Edge(from, c));
        }
        
        int[] dist = dijkstra(s, n);
        // System.out.println(Arrays.toString(dist));
        
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == MAX_VALUE) continue;
            int tmp = dist[i];
            int[] ndist = dijkstra(i, n);
            
            tmp += ndist[a];
            tmp += ndist[b];
            
            answer = Math.min(answer, tmp);
        }
        return answer;
    }
    
    private int[] dijkstra(int s, int n) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, MAX_VALUE);
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(s, 0));
        dist[s] = 0;
        boolean[] vis = new boolean[n+1];
        
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (vis[e.idx]) continue;
            vis[e.idx] = true;
            
            for (Edge next : adj[e.idx]) {
                if (dist[e.idx] + next.weight < dist[next.idx]) {
                    dist[next.idx] = dist[e.idx] + next.weight;
                    pq.add(new Edge(next.idx, dist[next.idx]));
                }
            }
        }
        
        return dist;
    }
}
