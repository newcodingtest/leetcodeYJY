import java.io.*;
import java.util.*;

public class Main {
    //정점개수 V, 간선 개수 E, 시작정점 번호K
    static int V,E,K;
    static int[] dp;

    static List<Node>[] list;
    //시작점에서 모든 정점까지의 최단 경로값 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        dp = new int[V+1];
        list = new ArrayList[V+1];
        for(int i=0; i<=V; i++){
            list[i]=new ArrayList<>();
        }

        Arrays.fill(dp,Integer.MAX_VALUE-1);

        for (int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end,cost));
        }

        dijkstra(K);
        StringBuilder sb =new StringBuilder();
        for (int i=1; i<=V; i++){
            if(dp[i]==Integer.MAX_VALUE-1) {
                sb.append("INF\n");
            }else{
                sb.append(dp[i]+"\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void dijkstra(int target){
        PriorityQueue<Node>q = new PriorityQueue<>();
        q.add(new Node(K,0));
        dp[K]=0;

        while (!q.isEmpty()){
            Node n = q.poll();
            for (Node e : list[n.idx]){
                if(dp[e.idx]>n.cost+e.cost){
                    dp[e.idx]=n.cost+e.cost;
                    q.add(new Node(e.idx,dp[e.idx]));
                }

            }
        }

    }

    static class Node implements Comparable<Node> {
        int idx;
        int cost;

        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }

}

