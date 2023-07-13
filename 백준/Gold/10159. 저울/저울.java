import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static int N, M;
    static boolean[] isVisited;
    static int MAX = 100000000;
    static int ANS = MAX;
    static List[] list;
    static boolean[][] map;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new boolean[N+1][N+1];
        list = new List[N+1];
        dp = new int[N+1];

        for (int i=1; i<=N; i++){
            list[i] = new ArrayList();
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int big = Integer.parseInt(st.nextToken());
            int small = Integer.parseInt(st.nextToken());

            list[big].add(small);
            map[big][small]=true;
        }

        for (int i=1; i<=N; i++){
            for (int j=1; j<=N; j++){
                for (int k=1; k<=N; k++){
                    if (map[j][i] && map[i][k] ){
                        map[j][k] =true;
                    }
                }
            }
        }

        int cnt = 1;
        for (int k=1; k<=N; k++){
            for (int j=1; j<=N; j++){
                if(k==j) continue;
                if(map[k][j] || map[j][k] ){
                    cnt++;
                }
            }
            System.out.println(N-cnt);
            cnt = 1;
        }
    }

    public static void dfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int cnt = 1;

        while(!q.isEmpty()){
            int p = q.poll();
            isVisited[p]=true;

            for (int i=0; i<list[p].size(); i++){
                int s = Integer.parseInt(list[p].get(i).toString());
                if (!isVisited[s]){
                    isVisited[s]=true;
                    q.add(s);
                    ++cnt;
                }
            }

        }
        sb.append(N-cnt+"\n");
    }
}

