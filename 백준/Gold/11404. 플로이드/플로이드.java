import java.io.*;
import java.util.*;


public class Main {
    static int n,m;
    static int[][] dp;
    static int MAX = 1000000000;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dp = new int[n+1][n+1];

        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){
                dp[i][j]=MAX;
                if(i==j){
                    dp[i][j]=0;
                }
            }
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dp[start][end]=Math.min(dp[start][end],cost);
        }
        //시작 도시와 도착 도시가 같은 경우는 없다
        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){
                for (int k=1; k<=n; k++){
                    if(dp[j][k]>dp[j][i]+dp[i][k]){
                        dp[j][k]=dp[j][i]+dp[i][k];
                    }

                }
            }
        }
        sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(dp[i][j] == MAX) {
                    dp[i][j] = 0;
                }

                sb.append(dp[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

