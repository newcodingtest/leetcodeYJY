package 프로그래머스.level2;

//효율성 탈락
public class 게임맵최단거리 {
    static int[] rows = {-1,1,0,0};
    static int[] cols = {0,0,-1,1};
    static int N,M;
    static boolean[][] visited;
    static int MIN = Integer.MAX_VALUE;
    static int[][] test;
    public static int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        test = maps.clone();
        N = maps.length;
        M = maps[0].length;
        bfs(0, 0, 0);
        return MIN==Integer.MAX_VALUE?-1:MIN;
    }

    public static void bfs(int x, int y, int cnt) {
        if(x==N-1 && y==M-1 ) {
            MIN = Math.min(MIN, cnt+1);
        }else {
            for(int i=0; i<4; i++) {
                int nx = x+rows[i];
                int ny = y+cols[i];
                if(nx>=0 && ny>=0 && nx<=N-1 && ny<=M-1) {
                    if(test[nx][ny]==1&&!visited[nx][ny]) {
                        visited[nx][ny]=true;
                        bfs(nx, ny, cnt+1);
                        visited[nx][ny]=false;
                    }

                }
            }
        }

    }
}
