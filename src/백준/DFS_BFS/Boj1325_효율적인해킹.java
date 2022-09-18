package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Boj1325_효율적인해킹 {
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] check;
    static int N;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        list = new List[N+1];
        visited = new boolean[N+1];
        check = new int[N+1];

        for (int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int key = Integer.valueOf(st.nextToken());
            int elem = Integer.valueOf(st.nextToken());
            list[elem].add(key);
        }
        int maxSize = 0;
        for (int i=1; i<=N; i++) {
            DFS(i);
            if (check[i] > maxSize) {
                maxSize = check[i];
            }
        }

        for (int i=1; i<check.length; i++){
            if(check[i]==maxSize){
                bw.write(i+" ");
            }
        }
        bw.flush();
        bw.close();
    }
    public static void DFS(int start){
        Queue<Integer>q = new LinkedList<>();
        visited = new boolean[N+1];
        int cnt = 0;
        q.add(start);

        while (!q.isEmpty()){
            int parent = q.poll();
            visited[parent]=true;
            for (int elem:list[parent]){
                if(!visited[elem]){
                    visited[elem]=true;
                    q.add(elem);
                    check[start]++;
                }
            }
        }
    }
}
