package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj11752_트리의부모찾기 {
    static int N;
    static List<Integer>[] list;
    static int[] parents;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        list = new List[N+1];
        visited = new boolean[N+1];
        parents = new int[N+1];

        for(int i=0; i<=N; i++){
            list[i] = new ArrayList();
        }

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                DFS(i);
            }
        }

        //두번재 노드부터 출력하자
        for(int i=2; i<=N; i++){
            System.out.println(parents);
        }
    }

    public static void DFS(int target){
        visited[target]=true;

        for(int elem : list[target]){
            if(!visited[elem]){
                parents[elem] = target;
                DFS(elem);
            }
        }
    }
}
