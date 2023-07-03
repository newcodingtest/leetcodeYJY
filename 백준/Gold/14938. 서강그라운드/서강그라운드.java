import java.io.*;
import java.util.*;


public class Main {
    static int n,m,r;
    static List<Node>[] list;
    static int[] element;
    static boolean[] isVisited;
    static int answer = Integer.MIN_VALUE;
    //필드에서 예은이가 얻을 수 있는 아이템의 최대 개수이다.
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //지역의 개수
        n = Integer.parseInt(st.nextToken());
        //수색 범위
        m = Integer.parseInt(st.nextToken());
        //길이 개수
        r = Integer.parseInt(st.nextToken());

        list = new List[n+1];
        element = new int[n+1];
        isVisited = new boolean[n+1];
        for (int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++){
            element[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[x].add(new Node(y,cost));
            list[y].add(new Node(x,cost));
        }


        for (int i=0; i<n; i++){
            bfs(i+1);
        }

        System.out.println(answer);
    }

    public static void bfs(int start){
        Arrays.fill(isVisited,false);

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start,0));

        int sum = 0;
        while (!q.isEmpty()){
            Node n = q.poll();

            if (isVisited[n.idx] || n.cost>m) continue;
            isVisited[n.idx]=true;
            sum+= element[n.idx];
            for (Node ele : list[n.idx]){
                q.add(new Node(ele.idx,n.cost+ele.cost));
            }
        }
        answer = Math.max(answer,sum);
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

