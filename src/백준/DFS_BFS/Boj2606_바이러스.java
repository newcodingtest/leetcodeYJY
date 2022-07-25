package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Boj2606_바이러스 {
    static List<List<Integer>>list= new ArrayList<>();
    static boolean[] visited;
    static int cnt=0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }

        visited = new boolean[N+1];

        int E = Integer.parseInt(br.readLine());

        StringTokenizer st = null;

        for(int i=0; i<E; i++){
             st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int son = Integer.parseInt(st.nextToken());

            list.get(parent).add(son);
            list.get(son).add(parent);
        }

        dfs(1);

        System.out.println(cnt);

    }

    public static void dfs(int idx){
        visited[idx]=true;

        for(int i=0; i<list.get(idx).size(); i++){
           int temp = list.get(idx).get(i);
            if(!visited[temp]){
                visited[temp] = true;
                cnt++;
                dfs(temp);
            }
        }
    }

}
