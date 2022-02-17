package 백준.그래프검색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node2{
    int node;
    int distance;
    public Node2(int a, int b){
        node = a;
        distance = b;
    }
}
public class Boj_1167 {
    static List<Node2>[]list;
    static Queue<Integer>queue;
    static int max = 0;
    static int node;
    static boolean[] visited;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        queue = new LinkedList<>();
        list = new List[n+1];
        for (int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            while(true) {
                int b = Integer.parseInt(st.nextToken());
                if(b==-1){
                    break;
                }

                int c = Integer.parseInt(st.nextToken());
                list[a].add(new Node2(b,c));
                list[b].add(new Node2(a,c));
            }
        }

        bfs(1,0);

        visited = new boolean[n+1];
        bfs(node,0);
        System.out.println(max);

    }
    public static void bfs(int start, int length){
        if(length>max){
            max = length;
            node = start;
        }

        visited[start]=true;

            for(Node2 n : list[start]){
                if(!visited[n.node]){
                    visited[n.node]=true;
                    bfs(n.node,n.distance+length);
                }

        }

    }
}
