package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//dfs를 사용한 방법
public class Boj14501_퇴사_1 {
    static int N;
    static Node[] list;
    static int MAX = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        list = new Node[N];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            list[i] = new Node(t,p);
        }

        DepthFirstSearch(0,0);


        System.out.println(MAX);

    }

    private static void DepthFirstSearch(int start, int sum) {
        //조건 해당시 최대값 갱신
        if(start == N){
            MAX = Math.max(MAX,sum);
            return;
        }

        //퇴사 날을 초과했을 경우 탈출
        if(start>N){
            return;
        }
        Node n = list[start];

        //상담을 하는경우 날짜와 cost가 증가한다.
        DepthFirstSearch(start+n.day, sum+n.cost);
        //상담을 안하는 경우 => 날짜만 지나가고 cost는 증가하지 않음
        DepthFirstSearch(start+1, sum);
    }

    static class Node{
        int day;
        int cost;

        public Node(int day, int cost){
            this.day = day;
            this.cost = cost;
        }
    }
}
