package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2606_1 {
    static boolean visited[];
    static List<Integer>[] list;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        list = new ArrayList[N+1];

        for (int i=0; i<list.length; i++){
            list[i] = new ArrayList<>();
        }

        for (int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int key = Integer.valueOf(st.nextToken());
            int ele = Integer.valueOf(st.nextToken());
            list[key].add(ele);
            list[ele].add(key);
        }

        System.out.println(DFS(1));
    }

    public static int DFS(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int cnt = 0;
        while (!q.isEmpty()){
            int target = q.poll();
            visited[target]=true;

            for (int i=0; i<list[target].size(); i++){
                int temp = list[target].get(i);
                if(!visited[temp]){
                    visited[temp]=true;
                    cnt++;
                    q.add(temp);
                }
            }
        }
        return cnt;
    }
}
