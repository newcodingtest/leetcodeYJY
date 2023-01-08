package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj14620_꽃길 {
    static int N;
    static int[][] maps;
    static int MIN = Integer.MAX_VALUE;
    static int[] rows = {-1,1,0,0};
    static int[] cols = {0,0,-1,1};
    static boolean[][] visited;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maps = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st = null;
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for (int j=0; j<N; j++){
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BFS(0,0);
        System.out.println(MIN);
    }

    public static void BFS(int cnt, int value){
        if(cnt==3){
            MIN = Math.min(MIN, value);
            return;
        }else{
            for (int i=1; i<N-1; i++){
                for (int j=1; j<N-1; j++){
                    if(!visited[i][j] && isValid(i,j)){
                        int sum = sum(i,j);
                        BFS(cnt+1, value+sum);
                        clearVisited(i,j);
                    }
                }
            }
        }


    }

    public static boolean isValid(int x, int y){
        for (int i=0; i<4; i++){
            int dx = rows[i]+x;
            int dy = cols[i]+y;

            if (visited[dx][dy]){
                return false;
            }
        }
        return true;
    }

    public static int sum(int x, int y){
        visited[x][y] = true;
        int result = maps[x][y];
        for (int i=0; i<4; i++){
            int dx = rows[i]+x;
            int dy = cols[i]+y;

            visited[dx][dy] = true;
            result+=maps[dx][dy];
        }
        return result;
    }

    public static void clearVisited(int x, int y){
        visited[x][y] = false;
        for (int i=0; i<4; i++){
            int dx = rows[i]+x;
            int dy = cols[i]+y;

            visited[dx][dy] = false;
        }

    }
}
