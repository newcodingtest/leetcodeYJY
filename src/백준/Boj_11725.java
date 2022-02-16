package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_11725 {
    static Queue<Integer> queue = new LinkedList<>();
    static List<Integer>[] list;
    static int[] parent;
    static boolean visited[];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        parent = new int[N+1];
        visited = new boolean[N+1];

        for (int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for (int i=0; i<N-1; i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for (int i=2; i<=N; i++){
            System.out.println(parent[i]);
        }

    }

    static void dfs(int root){
        visited[root]=true;
        for (int child : list[root]){
            if(!visited[child]){
                visited[child]=true;
                parent[child]=root;
                dfs(child);
            }
        }
    }

    static void bfs(int root){
        visited[root]=true;
        queue.add(root);
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            for (int child : list[temp]) {
                if (!visited[child]) {
                    visited[child] = true;
                    parent[child] = root;
                    bfs(child);
                }
            }

        }
    }
}
