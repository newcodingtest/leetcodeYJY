package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2468_안전영역 {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int MAX = Integer.MIN_VALUE;
    static int HEIGHT = Integer.MIN_VALUE;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st = null;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]>HEIGHT) {
                    HEIGHT=arr[i][j];
                }
            }
        }

        backTracking();
        System.out.println(MAX);
    }

    //요소, 깊이
    public static void backTracking() {
        for(int height=0; height<=HEIGHT; height++) {
            int cnt = 0;
            visited = new boolean[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j] && arr[i][j]>height) {
                        cnt++;
                        search(i,j,height);
                    }
                }
            }
            MAX = Math.max(MAX, cnt);
        }
    }

    public static void search(int x, int y,int height) {
        visited[x][y]=true;

        if(x-1>=0 && !visited[x-1][y] &&  arr[x-1][y]>height) {
            search(x-1, y, height);
        }
        if(x+1<arr.length && !visited[x+1][y] &&  arr[x+1][y]>height) {
            search(x+1, y, height);
        }
        if(y-1>=0 && !visited[x][y-1] && arr[x][y-1]>height) {
            search(x, y-1, height);
        }
        if( y+1<arr[0].length && !visited[x][y+1] && arr[x][y+1]>height) {
            search(x, y+1, height);
        }

    }
}
