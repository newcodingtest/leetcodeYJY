import java.util.*;
class Solution {
        static int[][] dp;
    static int INF = 100000000;
    public int solution(int n, int s, int a, int b, int[][] fares) {
           dp = new int[n+1][n+1];
        for (int i=1; i<=n; i++){
            Arrays.fill(dp[i], INF);
             dp[i][i]=0;
        }

        for (int i=0; i<fares.length; i++){
            int start = fares[i][0];
            int end = fares[i][1];
            int cost = fares[i][2];

            dp[start][end] = cost;
            dp[end][start] = cost;
        }

        //플로이드
        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){
                if(i==j) continue;
                for (int k=1; k<=n; k++){
                    if(dp[j][k]>dp[j][i]+dp[i][k]){
                        dp[j][k]=dp[j][i]+dp[i][k];
                    }
                }
            }
        }


        int answer = dp[s][a]+dp[s][b];

        for (int i=1; i<=n; i++){
            answer = Math.min(answer, dp[s][i]+dp[i][a]+dp[i][b]);
        }

        return answer;
    }
}