package 백준.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2193 {
    static long dp[];
    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        dp = new long[input+1];

        dp[0]=0;
        dp[1]=1;

        for (int i=2; i<=input; i++){
          dp[i]=dp[i-1]+dp[i-2];
        }

        System.out.println( dp[input]);

    }
}
