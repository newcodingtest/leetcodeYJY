package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj18513_샘터 {
    static int N,K;
    static int MAX = 100000000;
    static int[] move = {-1,1}; //왼, 오
    static HashSet<Integer> visited = new HashSet<>();
    static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            int tmp = Integer.parseInt(st.nextToken());

            q.add(new Node(tmp,0));
            visited.add(tmp);
        }
        System.out.println(bfs());
    }

    public static long bfs(){
        long result = 0;
        int cnt = 0;

        while (!q.isEmpty()){
            Node n = q.poll();

            for (int i=0; i<2; i++){
                int key = n.x + move[i];

                if(key<MAX && -MAX<key){
                    if(!visited.contains(key)){
                        cnt++;
                        result += n.dist+1;

                        if(cnt == K){ return result;}

                        visited.add(key);
                        q.add(new Node(key,n.dist+1));
                    }
                }
            }
        }
     return result;
    }

    static class Node{
        int x;
        int dist;

        public Node(int x, int dist){
            this.x = x;
            this.dist = dist;
        }
    }
}
