package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2206_벽부수고이동하기 {
    static int[] rows = {-1,1,0,0};
    static int[] cols = {0,0,-1,1};
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i=0; i<N; i++){
            String str = br.readLine();
            for (int j=0; j<M; j++){
                map[i][j] =str.charAt(j)-'0';
            }
        }
        q.add(new Node(0,0,1,false));


        System.out.println( bfs());

    }

    public static long bfs(){
        while (!q.isEmpty()){
            Node n = q.poll();
            if(n.x == N-1 && n.y == M-1){
                return n.dist;
            }

            for (int i=0; i<4; i++){
                int dx = rows[i]+n.x;
                int dy = cols[i]+n.y;

                if(dx<0 || dx>=N || dy<0 || dy>=M) continue;

                //벽이 아닐때
                if(map[dx][dy]==0){
                    //벽제거를 안했으며, 방문도 안했으면
                    if(!n.isRemove && !visited[dx][dy][0]){
                        q.add(new Node(dx,dy,n.dist+1,false));
                        visited[dx][dy][0]=true;
                    }
                    //벽제거를 이미 했고, 방문을 안했으면
                    else if(n.isRemove && !visited[dx][dy][1]){
                        q.add(new Node(dx,dy,n.dist+1,true));
                        visited[dx][dy][1]=true;
                    }
                }
                //벽일떼
                else {
                    //벽을 제거한적이 없으면
                    if(!n.isRemove){
                        q.add(new Node(dx,dy,n.dist+1,true));
                        visited[dx][dy][1]=true;
                    }
                }
            }

        }
        return -1;
    }

    static class Node{
        int x;
        int y;
        int dist;
        boolean isRemove; // 1:use, 0:not use

        public Node(int x, int y, int dist, boolean isRemove){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.isRemove = isRemove;
        }
    }
}
