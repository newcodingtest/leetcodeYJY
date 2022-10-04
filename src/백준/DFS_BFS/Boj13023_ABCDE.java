package 백준.DFS_BFS;

import java.io.*;
import java.util.*;

public class Boj13023_ABCDE {
    static int N,M;
    static List<Integer>[] list;
    static boolean[] visited;
    static int result = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        list = new List[N];
   
        for (int i=0; i<N; i++){
            list[i] = new ArrayList<>();
        }
        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        DFS(0,1);
        System.out.println(0);

    }

    public static void DFS(int x, int len){
        if(len==5){
            System.out.println(1);
            System.exit(0);
        }
        visited[x]=true;
        for (int i=0; i<list[x].size(); i++){
            int temp = list[x].get(i);
            if(!visited[temp]){
                visited[temp]=true;
                DFS(temp,len+1);
                visited[temp]=false;
            }
        }
    }
}
