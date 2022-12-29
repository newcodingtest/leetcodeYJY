package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14620_꽃길 {
    static int[] rows = {-1,1,0,0};
    static int[] cols = {0,0,-1,1};
    static int[][] flowers;
    static boolean[][] visited;
    static int N;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args)throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        flowers = new int[N][N];
        visited = new boolean[N][N];
        StringTokenizer st = null;
        for (int x=0; x<N; x++){
            st = new StringTokenizer(br.readLine());
            for (int y=0; y<N; y++){
                flowers[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        BFS(0,0);

        System.out.println(min);

    }

    private static void BFS( int cnt, int cost) {
        if(cnt==3){
            min = Math.min(cost,min);
            return;
        }

        for (int i=1; i<N-1; i++){
            for (int j=1; j<N-1; j++){
                //씨앗 심는 포인트 방문 체크 && 주변 꽃 필수있는 자리 방문 체크
                if(!visited[i][j] && check(i,j)){
                    visited[i][j]=true;
                    int hap = sum(i,j);

                    BFS(cnt+1,cost+hap);
                    visitedClear(i,j);
                }
            }
        }
    }

    private static void visitedClear(int x, int y) {
        visited[x][y]=false;
        for (int i=0; i<4; i++){
            int dx = x+rows[i];
            int dy = y+cols[i];

            visited[dx][dy]=false;
        }
    }

    private static int sum(int x, int y) {
        int sum = flowers[x][y];
        for (int i=0; i<4; i++){
            int dx = x+rows[i];
            int dy = y+cols[i];

            visited[dx][dy]=true;
            sum+=flowers[dx][dy];
        }
        return sum;
    }

    private static boolean check(int x, int y) {
        for (int i=0; i<4; i++){
            int dx = x+rows[i];
            int dy = y+cols[i];

            if(visited[dx][dy]){
                return false;
            }
        }
        return true;
    }

}
