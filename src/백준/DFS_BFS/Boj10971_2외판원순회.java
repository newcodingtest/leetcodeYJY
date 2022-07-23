package 백준.DFS_BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10971_2외판원순회 {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st = null;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            backTracking(i,i,0,0);
        }
        System.out.println(MIN);
    }

    //요소, 깊이
    public static void backTracking(int start, int i, int sum, int cnt) {
        if(cnt == N && start == i) {
            MIN = Math.min(MIN, sum);
            return;
        }

        for(int j=0; j<N; j++) {
            if(!visited[i] && arr[i][j]>0) {
                visited[i]=true;
                sum += arr[i][j];
                backTracking(start, j, sum, cnt+1);
                visited[i]=false;
                sum -= arr[i][j];
            }
        }
    }
}
