package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16993_직사각형탈출 {
    static int[][] arr;
    static boolean[][] visited;
    static int[] rows = {-1,1,0,0};
    static int[] cols = {0,0,-1,1};
    static int N,M;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for (int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
    }
}
