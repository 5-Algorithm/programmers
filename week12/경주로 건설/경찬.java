import java.util.*;

class Solution {
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};
    
    class Node {
        int r, c, dir;
        
        public Node(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
    
    int N;
    public int solution(int[][] board) {
        int answer = 987654321;
        N = board.length;
        int[][][] nboard = new int[N][N][4];
        boolean[][] vis = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) vis[i][j] = true;
            }
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0));
        q.add(new Node(0, 0, 1));
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            int dir = curr.dir;
            
            // 직진
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if (isValid(nr, nc) && !vis[nr][nc]) {
                // 방문한적 없거나 현재 비용이 더 효율적이면
                if (nboard[nr][nc][dir] == 0 || nboard[r][c][dir] + 100 <= nboard[nr][nc][dir]) {
                    q.add(new Node(nr, nc, dir));
                    nboard[nr][nc][dir] = nboard[r][c][dir] + 100;
                }
            }
            
            // 좌회전
            int ndir = (dir + 1) % 4;
            nr = r + dr[ndir];
            nc = c + dc[ndir];
            if (isValid(nr, nc) && !vis[nr][nc]) {
                // 방문한적 없거나 현재 비용이 더 효율적이면
                if (nboard[nr][nc][ndir] == 0 || nboard[r][c][dir] + 600 <= nboard[nr][nc][ndir]) {
                    q.add(new Node(nr, nc, ndir));
                    nboard[nr][nc][ndir] = nboard[r][c][dir] + 600;
                }
            }
            
            // 우회전
            ndir = (dir + 3) % 4;
            nr = r + dr[ndir];
            nc = c + dc[ndir];
            if (isValid(nr, nc) && !vis[nr][nc]) {
                // 방문한적 없거나 현재 비용이 더 효율적이면
                if (nboard[nr][nc][ndir] == 0 || nboard[r][c][dir] + 600 <= nboard[nr][nc][ndir]) {
                    q.add(new Node(nr, nc, ndir));
                    nboard[nr][nc][ndir] = nboard[r][c][dir] + 600;
                }
            }
        }
        
        for (int i = 0; i < 4; i++) {
            if (nboard[N-1][N-1][i] == 0) continue;
            answer = Math.min(answer, nboard[N-1][N-1][i]);
        }

        return answer;
    }
    
    boolean isValid(int nr, int nc) {
        if (nr == 0 && nc == 0) return false;
        if (nr >= 0 && nc >= 0 && nr < N && nc < N) return true;
        return false;
    }
}

/*
테스트 1 〉	통과 (0.45ms, 72.4MB)
테스트 2 〉	통과 (0.29ms, 75.5MB)
테스트 3 〉	통과 (0.43ms, 74.1MB)
테스트 4 〉	통과 (0.32ms, 71.5MB)
테스트 5 〉	통과 (1.28ms, 76.6MB)
테스트 6 〉	통과 (1.76ms, 76.9MB)
테스트 7 〉	통과 (1.82ms, 73.9MB)
테스트 8 〉	통과 (1.42ms, 78MB)
테스트 9 〉	통과 (1.54ms, 75.9MB)
테스트 10 〉	통과 (4.30ms, 82.4MB)
테스트 11 〉	통과 (197.29ms, 145MB)
테스트 12 〉	통과 (8.66ms, 80.1MB)
테스트 13 〉	통과 (0.96ms, 76.6MB)
테스트 14 〉	통과 (1.03ms, 76.7MB)
테스트 15 〉	통과 (1.54ms, 71.2MB)
테스트 16 〉	통과 (4.48ms, 74.3MB)
테스트 17 〉	통과 (54.86ms, 96.4MB)
테스트 18 〉	통과 (6.54ms, 74MB)
테스트 19 〉	통과 (46.82ms, 87.8MB)
테스트 20 〉	통과 (2.41ms, 73MB)
테스트 21 〉	통과 (1.67ms, 70.8MB)
테스트 22 〉	통과 (0.59ms, 71.5MB)
테스트 23 〉	통과 (0.36ms, 73.8MB)
테스트 24 〉	통과 (0.60ms, 74.9MB)
테스트 25 〉	통과 (0.46ms, 68.9MB)
*/

// failed 2

import java.util.*;

class Solution {
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};
    
    class Node {
        int r, c, dir;
        
        public Node(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
    
    int N;
    public int solution(int[][] board) {
        int answer = 0;
        N = board.length;
        // boolean[][] vis = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) board[i][j] = -1;
            }
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0));
        q.add(new Node(0, 0, 1));
        // vis[0][0] = true;
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            int dir = curr.dir;
            
            // 직진
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if (isValid(nr, nc) && board[nr][nc] != -1) {
                // 방문한적 없거나 현재 비용이 더 효율적이면
                if (board[nr][nc] == 0 || board[r][c] + 100 <= board[nr][nc]) {
                    q.add(new Node(nr, nc, dir));
                    board[nr][nc] = board[r][c] + 100;
                }
            }
            
            // 좌회전
            int ndir = (dir + 1) % 4;
            nr = r + dr[ndir];
            nc = c + dc[ndir];
            if (isValid(nr, nc) && board[nr][nc] != -1) {
                // 방문한적 없거나 현재 비용이 더 효율적이면
                if (board[nr][nc] == 0 || board[r][c] + 600 <= board[nr][nc]) {
                    q.add(new Node(nr, nc, ndir));
                    board[nr][nc] = board[r][c] + 600;
                }
            }
            
            // 우회전
            ndir = (dir + 3) % 4;
            nr = r + dr[ndir];
            nc = c + dc[ndir];
            if (isValid(nr, nc) && board[nr][nc] != -1) {
                // 방문한적 없거나 현재 비용이 더 효율적이면
                if (board[nr][nc] == 0 || board[r][c] + 600 <= board[nr][nc]) {
                    q.add(new Node(nr, nc, ndir));
                    board[nr][nc] = board[r][c] + 600;
                }
            }
        }
        
        // for (int[] row : board) {
        //     System.out.println(Arrays.toString(row));
        // }
        
        answer = board[N - 1][N - 1];
        return answer;
    }
    
    boolean isValid(int nr, int nc) {
        if (nr == 0 && nc == 0) return false;
        if (nr >= 0 && nc >= 0 && nr < N && nc < N) return true;
        return false;
    }
}

/*
테스트 1 〉	통과 (0.28ms, 72.9MB)
테스트 2 〉	통과 (0.27ms, 74.4MB)
테스트 3 〉	통과 (0.31ms, 73.4MB)
테스트 4 〉	통과 (0.31ms, 75MB)
테스트 5 〉	통과 (0.38ms, 73.4MB)
테스트 6 〉	통과 (0.54ms, 78.8MB)
테스트 7 〉	통과 (0.62ms, 74.2MB)
테스트 8 〉	통과 (0.56ms, 77.1MB)
테스트 9 〉	통과 (0.42ms, 70.8MB)
테스트 10 〉	통과 (0.92ms, 77.7MB)
테스트 11 〉	통과 (1.23ms, 77.5MB)
테스트 12 〉	통과 (1.51ms, 73.6MB)
테스트 13 〉	통과 (0.46ms, 73.6MB)
테스트 14 〉	통과 (0.42ms, 74.8MB)
테스트 15 〉	통과 (0.55ms, 73.5MB)
테스트 16 〉	통과 (0.85ms, 77.6MB)
테스트 17 〉	통과 (2.25ms, 75.8MB)
테스트 18 〉	통과 (1.12ms, 67.8MB)
테스트 19 〉	통과 (1.25ms, 74.4MB)
테스트 20 〉	통과 (1.13ms, 85MB)
테스트 21 〉	통과 (1.03ms, 75MB)
테스트 22 〉	통과 (0.44ms, 66.5MB)
테스트 23 〉	통과 (0.30ms, 72.6MB)
테스트 24 〉	통과 (0.30ms, 77.7MB)
테스트 25 〉	실패 (0.32ms, 74.7MB)
*/

// failed 1

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        N = board.length;
        vis = new boolean[N][N];
        vis[0][0] = true;
        
        DFS(board, 1, 0, 0, 100);
        DFS(board, 0, 1, 1, 100);
        answer = ans;
        return answer;
    }
    
    int N;
    boolean[][] vis;
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};
    int ans = 987654321;
    void DFS(int[][] board, int r, int c, int dir, int cost) {
        if (r < 0 || c < 0 || r >= N || c >= N) return;
        if (vis[r][c]) return;
        if (board[r][c] == 1) return;
        
        if (r == N - 1 && c == N - 1) {
            ans = Math.min(ans, cost);
            return;
        }
        
        vis[r][c] = true;
        int nr = r + dr[dir];
        int nc = c + dc[dir];
        DFS(board, nr, nc, dir, cost + 100);
        
        int ndir = (dir + 1) % 4;
        nr = r + dr[ndir];
        nc = c + dc[ndir];
        DFS(board, nr, nc, ndir, cost + 600);
        
        ndir = (dir + 3) % 4;
        nr = r + dr[ndir];
        nc = c + dc[ndir];
        DFS(board, nr, nc, ndir, cost + 600);
        vis[r][c] = false;
    }
}

/*
테스트 1 〉	통과 (0.04ms, 78.3MB)
테스트 2 〉	통과 (0.06ms, 71.6MB)
테스트 3 〉	통과 (0.04ms, 73.3MB)
테스트 4 〉	통과 (0.04ms, 74.2MB)
테스트 5 〉	통과 (0.09ms, 69.3MB)
테스트 6 〉	실패 (시간 초과)
테스트 7 〉	실패 (시간 초과)
테스트 8 〉	실패 (시간 초과)
테스트 9 〉	실패 (시간 초과)
테스트 10 〉	실패 (시간 초과)
테스트 11 〉	실패 (시간 초과)
테스트 12 〉	실패 (시간 초과)
테스트 13 〉	통과 (0.91ms, 78.4MB)
테스트 14 〉	통과 (14.34ms, 76.6MB)
테스트 15 〉	실패 (시간 초과)
테스트 16 〉	실패 (시간 초과)
테스트 17 〉	실패 (시간 초과)
테스트 18 〉	실패 (시간 초과)
테스트 19 〉	실패 (시간 초과)
테스트 20 〉	통과 (1.45ms, 81.7MB)
테스트 21 〉	통과 (1.17ms, 75.4MB)
테스트 22 〉	통과 (0.08ms, 74MB)
테스트 23 〉	통과 (0.07ms, 79.2MB)
테스트 24 〉	통과 (0.06ms, 74.8MB)
테스트 25 〉	통과 (0.04ms, 72.5MB)
*/
