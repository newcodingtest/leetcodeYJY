package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj2583_영역구하기 {
    static boolean[][] visited;
    static int[] rows = {-1,1,0,0};
    static int[] cols = {0,0,-1,1};
    static int N,M;
    static int count;
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        for(int i=0; i<K; i++) {
            st= new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());

            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            for(int x=x1; x<x2; x++) {
                for(int y=y1; y<y2; y++) {
                    visited[x][y]=true;
                }
            }
        }

        for(int x=0; x<N; x++) {

            for(int y=0; y<M; y++) {
                if(!visited[x][y]) {
                    bfs(x, y);
                    list.add(count);
                    count=0;
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);

        list.forEach(x -> {
            System.out.print(x+" ");
        });

    }
    private static void bfs(int x, int y) {
        count++;
        visited[x][y]=true;
        for(int i=0; i<4; i++) {
            int nx = x+rows[i];
            int ny = y+cols[i];

            if(nx>=0 && ny>=0 && nx<N && ny<M) {
                if(!visited[nx][ny]) {
                    bfs(nx, ny);
                }
            }
        }
    }
}
