package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1260_DFSBFS {
    static List<Integer>[] list;
    static boolean[] visited;
    static int N;
    static int M;
    static int START;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        START = Integer.valueOf(st.nextToken());

        list = new List[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<=N; i++){
            list[i] = new ArrayList();
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        for (int i=0; i<=N; i++){
            list[i].sort((o1, o2) -> {
                return o1-o2;
            });
        }
        DFS(START);
        BFS();
    }

    public static void DFS(int start){
        sb.append(start)
                .append(" ");
        visited[start] = true;
        for (int i=0; i<list[start].size(); i++){
            int elem = list[start].get(i);
            if(!visited[elem]){
                DFS(elem);
            }
        }
    }
    public static void BFS(){
        sb.append("\n");
        visited = new boolean[N+1];
        Queue<Integer>q = new LinkedList<>();
        q.add(START);
        visited[START]=true;

        while (!q.isEmpty()){
            int temp = q.poll();
            sb.append(temp+" ");

            for (int i=0; i<list[temp].size(); i++){
                int elem = list[temp].get(i);
                if(!visited[elem]){
                    visited[elem]=true;
                    q.add(elem);
                }
            }
        }

        System.out.println(sb.toString());
    }
}
