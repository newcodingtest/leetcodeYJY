package 백준.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Boj_11726 {
    static int[] dp;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        dp = new int[m + 1];

             /*   for(int i=1; i<=m; i++){
                    if(i==1) dp[i]=1;
                    else if(i==2) dp[i]=2;
                    else dp[i]=(dp[i-1]+dp[i-2])%10007;
                }

                System.out.println(dp[m]);
*/
        dp[1] = 1;
        dp[2] = 2;

        sb.append(dp(m));

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    static int dp(int n) {
        if (n == 1 || n == 2) {
            return dp[n];
        } else {
            for (int i = 1; i <= n; i++) {
                dp[n] = dp(n - 1) + dp(n - 2);
            }
            return dp[n];
        }

    }

}
