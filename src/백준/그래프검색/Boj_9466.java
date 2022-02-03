import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Boj_9466 {
    public static int T;
    public static int N;
    public static int[] linking;
    public static boolean[] visited;
    public static boolean[] finished;
    public static int teamCount;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            linking = new int[N+1];

            st = new StringTokenizer(br.readLine()," ");
            for(int i = 1; i<N+1; i++){
                linking[i] = Integer.parseInt(st.nextToken());
            }

            finished = new boolean[N+1];
            visited = new boolean[N+1];
            teamCount = 0;
            for(int node  =1 ; node<=N ; node++){

                dfs(node);
            }
            bw.write(String.valueOf(N-teamCount)+"\n");
        }
        bw.flush();
    }
    public static void dfs(int node){
        visited[node] = true;
        int nextNode = linking[node];

        if(!visited[nextNode]){
            dfs(nextNode);
        }
        else{
            if(!finished[nextNode]){
                ++teamCount;
                while(nextNode!=node){
                    ++teamCount;
                    nextNode = linking[nextNode];
                }
            }
        }
        finished[node] = true;
    }
}