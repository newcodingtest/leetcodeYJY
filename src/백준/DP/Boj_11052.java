package 백준.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_11052 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];

        for (int i=1; i<=n; i++){
          dp[i]=Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {

            }
        }
    }
}
