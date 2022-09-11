package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178_미로탐색 {
    static int N,M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] rows = {-1,1,0,0};
    static int[] cols = {0,0,-1,1};
    static Queue<Node>q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        //1은 이동가능, 0은 불가능
        //1,1에서 출발 -> N,M 도착
        //최소 이동칸수 구하기
        for (int i=0; i<N; i++){
            String input = br.readLine();
            for (int j=0; j<M; j++){
                 arr[i][j] = input.charAt(j)-48;
            }
        }
        BFS(0,0,0);
    }

    public static void BFS(int x, int y, int cnt){
        visited[x][y] = true;
        q.add(new Node(x,y,cnt));

        while (!q.isEmpty()){
            Node n = q.poll();
            if(n.x+1==N && n.y+1==M){
                System.out.println(n.cnt+1);
                break;
            }
            isValid(n);
        }
    }

    public static void isValid(Node n){
        for (int i=0; i<4; i++){
            int tempX = rows[i]+n.x;
            int tempY = cols[i]+n.y;

            if(tempX>=0 && tempY>=0 && tempX<N && tempY<M){
                if(arr[tempX][tempY]==1 && !visited[tempX][tempY]){
                    visited[tempX][tempY] = true;
                    q.add(new Node(tempX,tempY,n.cnt+1));
                }
            }
        }
    }

    static class Node{
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
