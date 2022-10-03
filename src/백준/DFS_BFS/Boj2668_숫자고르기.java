package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2668_숫자고르기 {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static int last;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        visited = new boolean[N+1];
        for (int i=1; i<=N; i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        for (int i=1; i<=N; i++){
            if(!visited[i]){
                last = i;
                visited[i]=true;
                bfs(i);
                visited[i]=false;
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (int i:list){
            System.out.println(i);
        }


    }

    public static void bfs(int x){
        if(last == arr[x]){
            list.add(x);
        }

        if(!visited[arr[x]]){
            visited[arr[x]]=true;
            bfs(arr[x]);
            visited[arr[x]]=false;
        }
    }

    public static void valid(int x){

    }
}
