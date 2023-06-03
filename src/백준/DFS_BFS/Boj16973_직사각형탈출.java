package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16973_직사각형탈출 {
    static int N, M, H, W, S1, S2, F1, F2, CNT;
    static int diffRow, diffCol;
    static int[][] arr;
    static boolean[][] visited;
    static int[] row = {-1,1,0,0};
    static int[] col = {0,0,-1,1};
    static Queue<Node>q = new LinkedList();
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for (int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for (int j=1; j<=M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        S1 = Integer.parseInt(st.nextToken());
        S2 = Integer.parseInt(st.nextToken());

        F1 = Integer.parseInt(st.nextToken());
        F2 = Integer.parseInt(st.nextToken());

        bfs(S1,S2);
    }

    public static void bfs(int x, int y){
        q.add(new Node(x,y,0));
        visited[x][y]=true;
        while (!q.isEmpty()){
            Node n = q.poll();
            if(n.x==F1 && n.y==F2){
                System.out.println(n.value);
                System.exit(0);
                break;
            }

            isValid(n.x,n.y,n.value);
        }
    }

    public static void isValid(int x, int y, int cnt){
        visited[x][y]=true;
        for (int i=0; i<4; i++){
            int nx = row[i]+x;
            int ny = col[i]+y;

            if(nx<1 || ny<1 || nx>N || ny>M || visited[nx][ny]) continue;
            if(!isOtherValid(nx,ny)) continue;

            visited[x][y]=true;
            q.add(new Node(nx,ny,cnt+1));
        }
    }

    public static boolean isOtherValid(int x, int y){
        for (int i=x; i<x+H; i++){
            for (int j=y; j<y+W; j++){
                if(i<1 || i>N || j<1 || j>M || arr[i][j]==1){
                    return false;
                }
            }
        }
        return true;
    }

    static class Node{
        int x;
        int y;
        int value;

        public Node(int row, int col, int cnt){
            x = row;
            y = col;
            value = cnt;
        }
    }

}
