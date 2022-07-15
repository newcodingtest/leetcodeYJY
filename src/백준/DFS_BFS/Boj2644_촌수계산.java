package 백준.DFS_BFS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Boj2644_촌수계산 {
    static List<Integer>[] list;
    static boolean[] visited;
    static int count;
    static int X,Y;
    static int cnt;
    static boolean result;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        list = new ArrayList[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        //비교 대상
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        cnt = Integer.parseInt(br.readLine());

        for(int i=0; i<=N; i++) {
            list[i]=new ArrayList();
        }

        for(int i=0; i<cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());

            list[temp1].add(temp2);
            list[temp2].add(temp1);
        }
        count = 0;
        bfs(X,0);
        if(!result) {
            System.out.println(-1);
        }else {
            System.out.println(count);
        }
    }

    private static void bfs(int idx,int nums) {
        visited[idx]=true;

        if(idx==Y) {
            count = nums;
            result = true;
            return;
        }

        for(int i=0; i<list[idx].size(); i++) {
            int temp = list[idx].get(i);
            if(!visited[temp]) {
                bfs(temp,nums+1);
            }
        }
    }

}
