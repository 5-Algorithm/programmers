import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    static class Node implements Comparable<Node>{
        int id, dist, type;
        List<Integer> link, distList;
        
        public Node(int id) {
            this.id = id;
            this.link = new ArrayList<>();
            this.distList = new ArrayList<>();
        }
        
        public Node(int id, int dist, int type) {
            this.id = id;
            this.dist = dist;
            this.type = type;
        }
        
        public int compareTo(Node n) {
            return this.dist - n.dist;
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        Node[] nodes = new Node[n + 1];
        
        for(int i = 0; i <= n; i++) {
            nodes[i] = new Node(i);
        }
        
        for(int i = 0; i < fares.length; i++){
            int st = fares[i][0];
            int ed = fares[i][1];
            int distance = fares[i][2];
            nodes[st].link.add(ed);
            nodes[st].distList.add(distance);
            nodes[ed].link.add(st);
            nodes[ed].distList.add(distance);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] vis = new boolean[3][n + 1];
        int[][] distFromNode = new int[3][n + 1];
        // type 0: S에서부터의 거리, 1: A에서부터의 거리, 2: B에서부터의 거리
        pq.offer(new Node(s, 0, 0));
        pq.offer(new Node(a, 0, 1));
        pq.offer(new Node(b, 0, 2));
        
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int now = curr.id;
            int dist = curr.dist;
            int type = curr.type;
            
            if(vis[type][now]) continue;
            vis[type][now] = true;
            distFromNode[type][now] = dist;
            for(int i = 0; i < nodes[now].link.size(); i++) {
                int next = nodes[now].link.get(i);
                if(vis[type][next]) continue;
                pq.offer(new Node(next, dist + nodes[now].distList.get(i), type));
            }
        }
        
        for(int i = 1; i <= n; i++) {
            // 조건문이라면 시작점부터 아예 연결X
            if(distFromNode[0][i] == 0 && i != s) continue;
            answer = Math.min(distFromNode[0][i] + distFromNode[1][i] + distFromNode[2][i], answer);
        }
        
        return answer;
    }
}

// 시작점에 아무곳도 방문하지 않은 상태(합승), A를 방문한 상태(따로 갈 경우), B를 방문한 상태(따로 갈 경우)
// 매 구간마다 세가지를 보내줘야하는듯 안터지나? 3의 n승인데

// A에서 출발해서 S, B에서 출발해서 S 를 구해서 겹치는 구간 가격 빼기
// A에서 올때 경로를 기억해두고 B에서 올때 겹치는 경로 만나면 바로 거기서부터 거리

// 정확성  테스트
// 테스트 1 〉	통과 (0.72ms, 74.5MB)
// 테스트 2 〉	통과 (0.60ms, 75.1MB)
// 테스트 3 〉	통과 (1.03ms, 78MB)
// 테스트 4 〉	통과 (0.98ms, 78.4MB)
// 테스트 5 〉	통과 (1.03ms, 74.7MB)
// 테스트 6 〉	통과 (1.06ms, 76.6MB)
// 테스트 7 〉	통과 (1.25ms, 75.8MB)
// 테스트 8 〉	통과 (0.86ms, 72.5MB)
// 테스트 9 〉	통과 (0.83ms, 65.6MB)
// 테스트 10 〉	통과 (0.84ms, 69.1MB)
// 효율성  테스트
// 테스트 1 〉	통과 (5.38ms, 52.1MB)
// 테스트 2 〉	통과 (16.73ms, 53.3MB)
// 테스트 3 〉	통과 (5.84ms, 53.2MB)
// 테스트 4 〉	통과 (4.70ms, 52.4MB)
// 테스트 5 〉	통과 (5.16ms, 54MB)
// 테스트 6 〉	통과 (6.09ms, 52.6MB)
// 테스트 7 〉	통과 (76.95ms, 69.1MB)
// 테스트 8 〉	통과 (82.60ms, 71.2MB)
// 테스트 9 〉	통과 (40.41ms, 68.9MB)
// 테스트 10 〉	통과 (42.83ms, 69.1MB)
// 테스트 11 〉	통과 (45.56ms, 66.5MB)
// 테스트 12 〉	통과 (55.54ms, 80.3MB)
// 테스트 13 〉	통과 (44.62ms, 59.6MB)
// 테스트 14 〉	통과 (46.49ms, 62.2MB)
// 테스트 15 〉	통과 (52.49ms, 61.8MB)
// 테스트 16 〉	통과 (5.61ms, 52.6MB)
// 테스트 17 〉	통과 (4.10ms, 52.3MB)
// 테스트 18 〉	통과 (3.11ms, 52.1MB)
// 테스트 19 〉	통과 (8.74ms, 52.8MB)
// 테스트 20 〉	통과 (13.35ms, 53.6MB)
// 테스트 21 〉	통과 (13.42ms, 53.6MB)
// 테스트 22 〉	통과 (61.29ms, 61.7MB)
// 테스트 23 〉	통과 (60.92ms, 63.3MB)
// 테스트 24 〉	통과 (49.48ms, 62.4MB)
// 테스트 25 〉	통과 (3.26ms, 53MB)
// 테스트 26 〉	통과 (3.47ms, 52.2MB)
// 테스트 27 〉	통과 (20.16ms, 53.9MB)
// 테스트 28 〉	통과 (14.01ms, 71.8MB)
// 테스트 29 〉	통과 (5.65ms, 52.3MB)
// 테스트 30 〉	통과 (3.97ms, 52.3MB)
