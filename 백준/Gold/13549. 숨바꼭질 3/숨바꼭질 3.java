import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,K;
    static int MIN = Integer.MAX_VALUE;

    static boolean[] isVisited;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        isVisited = new boolean[100001];
        BFS(N,0);
        System.out.println(MIN);
    }

    //
    public static void BFS(int start, int cnt) {
        PriorityQueue<Info> q = new PriorityQueue<>();
        q.add(new Info(start,cnt));
        isVisited[start]=true;

        while (!q.isEmpty()){
            Info p = q.poll();
            isVisited[p.start]=true;
            if(p.start==K){
                MIN = Math.min(MIN, p.cnt);
            }
            if (100000>=2*p.start&&!isVisited[2*p.start]){
                q.add(new Info(2*p.start,p.cnt));
            }

            if (p.start-1>=0&&!isVisited[p.start-1]){
                q.add(new Info(p.start-1,p.cnt+1));
            }

            if (100000>=p.start+1&&!isVisited[p.start+1]){
                q.add(new Info(p.start+1,p.cnt+1));
            }


        }

    }

    static class Info implements Comparable<Info> {
        int start;
        int cnt;

        public Info(int start, int cnt){
            this.start = start;
            this.cnt = cnt;
        }


        @Override
        public int compareTo(Info o) {
            return cnt-o.cnt;
        }
    }

}
