// failed

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
