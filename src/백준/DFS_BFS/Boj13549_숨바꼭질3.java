package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj13549_숨바꼭질3 {
    static int N,K;
    static int move = 0;
    static boolean[] visited;
    static int MAX = 100000;
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[MAX+1];

        bfs();

        System.out.println(MIN);
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N, 0));

        while(!q.isEmpty()) {
            Node node = q.poll();
            visited[node.x] = true;
            if(node.x == K) MIN = Math.min(MIN, node.time);

            if(node.x * 2 <= MAX && visited[node.x * 2] == false) q.offer(new Node(node.x * 2, node.time));
            if(node.x + 1 <= MAX && visited[node.x + 1] == false) q.offer(new Node(node.x + 1, node.time + 1));
            if(node.x - 1 >= 0 && visited[node.x - 1] == false) q.offer(new Node(node.x - 1, node.time + 1));
        }
    }

    public static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
