package 백준.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_9095 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new java.io.BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[12];

        
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;


        for(int i=4; i<=11; i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }

        for (int i=1; i<=m; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]+"\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


}
