package 백준.완전탐색;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj14500_테트로미노 {
    static int N,M;
    static int[][] tetris;
    static boolean[][] isVisited;
    static int[] rows = {1,-1,0,0};
    static int[] cols = {0,0,-1,1};
    static int MAX = Integer.MIN_VALUE;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tetris = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                tetris[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                isVisited[i][j]=true;
                dfs(i,j,1,tetris[i][j]);
                isVisited[i][j]=false;
            }
        }

        System.out.println(MAX);
    }

    public static void dfs(int row, int col, int cnt, int sum){
        if(cnt==4){
            MAX = Math.max(MAX,sum);
            return;
        }

        for (int i=0; i<4; i++){
            int dx = row+rows[i];
            int dy = col+cols[i];

            if(!isValid(dx,dy)){
                continue;
            }

            if(!isVisited[dx][dy]){
                if (cnt==2){
                    isVisited[dx][dy] = true;
                    dfs(row, col,cnt+1,sum+tetris[dx][dy]);
                    isVisited[dx][dy] = false;
                }

                isVisited[dx][dy] = true;
                dfs(dx,dy,cnt+1,sum+tetris[dx][dy]);
                isVisited[dx][dy] = false;
            }
        }

    }

    public static boolean isValid(int row, int col){
        if(row<0 || col<0 || row>=N || col>=M){
            return false;
        }
        return true;
    }
}
