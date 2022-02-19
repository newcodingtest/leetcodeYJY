package 백준.그래프검색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Node3{
    int node;
    int cost;

    public Node3(int a, int b){
        this.node = a;
        this.cost = b;
    }
}

public class Boj_1967 {
    static List<Node3>[] list;
    static int min;
    static int index;
    static boolean[] visited;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        list = new List[n+1];
        visited = new boolean[n+1];
        min = 0;
        index = 0;

        for (int i=0; i<=n; i++){
            list[i] = new LinkedList<>();

        }
        StringTokenizer st;
        for (int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
                int z = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                    list[z].add(new Node3(x,y));
                    list[x].add(new Node3(z,y));
        }
        br.close();
        dfs(1,0);
        visited = new boolean[n+1];
        dfs(index,0);
        System.out.println(min);
    }

    public static void dfs(int node , int distance){
        visited[node] = true;

        if(distance > min){
            min = distance;
            index = node;
        }

        for(Node3 n : list[node]){
            int temp_node = n.node;
            int temp_cost = n.cost;

            if(!visited[temp_node]){
                visited[temp_node]=true;

                dfs(temp_node,distance+temp_cost);
            }
        }

    }
}
