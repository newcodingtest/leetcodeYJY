package 백준.그래프검색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int x;
    int y;
    int count;
    public Node(int a, int b, int c) {
        this.x = a;
        this.y = b;
        this.count = c;
    }
}

public class Boj_2146{
    static int x;
    static int y;
    static int n;
    static int cnt=Integer.MAX_VALUE;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];


        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]==1) {
                    visited = new boolean[n][n];
                    sameland(i,j);
                    bfs(i, j);
                }
            }
        }
        if(cnt == Integer.MAX_VALUE) {
            cnt = 0 ;
        }

        System.out.println(cnt);

    }

    public static void bfs(int start, int end) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(start, end, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            int cx = node.x;
            int cy = node.y;
            int cc = node.count;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx<n && nx>=0 && ny<n && ny>=0) {
                    if(map[nx][ny]==0 && !visited[nx][ny]) {
                        visited[nx][ny]=true;
                        queue.add(new Node(nx, ny, cc+1));
                    }else if(map[nx][ny]==1 && !visited[nx][ny] && cc>0) {
                        cnt = Math.min(cnt, cc);
                    }
                }

            }

        }

    }

    public static void sameland(int start, int end) {
        visited[start][end]=true;
        for (int i = 0; i < 4; i++) {
            int cx = start + dx[i];
            int cy = end + dy[i];

            if(cx<n && cx>=0 && cy<n && cy>=0) {
                if(map[cx][cy]==1 && !visited[cx][cy]) {
                    sameland(cx, cy);

                }
            }

        }
    }

}
