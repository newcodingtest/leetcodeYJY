package 백준.DP;

import java.io.*;

public class Boj_11057 {
    static int dp[][];
    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());

        dp = new int[input+1][10];
        for(int i=0; i<=9; i++){
            dp[1][i]=1;
        }

        for (int i=2; i<=input; i++){
            for(int j=0; j<=9; j++){
                for (int k=0; k<=j; k++){
                    dp[i][j]+=dp[i-1][k];
                    dp[i][j]%=10007;
                }
            }
        }
        int result = 0;
        for(int i = 0; i<10; i++){
            result += dp[input][i];
        }
        System.out.println(result%10007);
    }
}
