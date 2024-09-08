import java.util.*;

class Solution {
    final int INF = 987654321;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        // start to 각각의 지점까지 dijkstra -> 여기까지 합승하겠다.
        // 각각의 지점에서 dijkstra -> to end까지 
        // 양방향이니까 end에서 dijkstra to 각각의 지점 -> 각 지점에서 여기까지 각자 가겠다.
        int[] startToPoint = new int[n+1];
        int[] endToPointA = new int[n+1];
        int[] endToPointB = new int[n+1];
        List<int[]>[] adja = new ArrayList[n+1];
        for(int i = 1; i<=n; i++)
            adja[i] = new ArrayList<>();
        
        for(int[] x : fares){
            adja[x[0]].add(new int[]{x[1],x[2]});
            adja[x[1]].add(new int[]{x[0],x[2]});
        }
        
        dijkstra(startToPoint,s,adja,n);
        dijkstra(endToPointA,a,adja,n);
        dijkstra(endToPointB,b,adja,n);
        int min = INF;
        for(int i = 1; i<=n; i++){
            if(startToPoint[i] != INF && endToPointA[i] != INF && endToPointB[i] != INF)
            min = Math.min(min, startToPoint[i]+endToPointA[i]+endToPointB[i]);
        }
        
        return min;
    }
    
    void dijkstra(int[] minDist, int start, List<int[]>[] adja, int n){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        });
        
        Arrays.fill(minDist,INF);
        minDist[start] = 0;
        boolean[] visited = new boolean[n+1];
        
        pq.add(new int[]{start,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(visited[cur[0]])
                continue;
            
            visited[cur[0]] = true;
            
            for(int[] x : adja[cur[0]]){
                if(!visited[x[0]] && minDist[x[0]] > minDist[cur[0]] + x[1]){
                    minDist[x[0]] = minDist[cur[0]] + x[1];
                    pq.add(new int[]{x[0],minDist[x[0]]});
                }
            }
        }
    }
}
