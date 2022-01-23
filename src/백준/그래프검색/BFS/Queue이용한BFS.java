package 백준.그래프검색.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue이용한BFS {
    static int[][] list;
    static boolean[] visited;
    static StringTokenizer st;
    static int N, M, start, end;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            list[start][end] = 1;
            list[end][start] = 1;
        }
        System.out.print("그래프 방문 순서");
        bfs(1);
    }

    static void bfs(int point){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(point);
        visited[point] = true;

        while(!queue.isEmpty()){
            int x = queue.poll();
            System.out.println(x+" ");
            for (int i=1; i<=N; i++){
                if (list[x][i]==1 && visited[i]==false){
                    queue.offer(1);
                    visited[i]=true;
                }
            }
        }

    }

}
