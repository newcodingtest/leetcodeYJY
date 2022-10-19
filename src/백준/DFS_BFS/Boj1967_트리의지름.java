package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1967_트리의지름 {
    static int N;
    static ArrayList<Node>[]list;
    static int MAX = Integer.MIN_VALUE;
    static boolean[] visited;
    static int maxIdx = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N =Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for (int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list[x].add(new Node(y,value));
            list[y].add(new Node(x,value));
        }

        //dfs를 통해서, 가중치가 높은 노드를 구하고
        //그 노드로 부터 다시 dfs를 돌려서 가중치의 합을 구한다.
        dfs(1,0);

        visited = new boolean[N+1];
        dfs(maxIdx,0);

        System.out.println(MAX);
    }

    public static void dfs(int x, int value){
        if(MAX<value){
            MAX = value;
            maxIdx = x;
        }
        visited[x]=true;

        for (Node n : list[x]){
            if(!visited[n.x]){
                dfs(n.x, value+n.value);
            }
        }
    }

    static class Node{
        int x;
        int value;

        public Node(int x, int value){
            this.x = x;
            this.value = value;
        }
    }
}
