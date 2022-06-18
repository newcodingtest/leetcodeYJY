package 백준.문자열;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Boj11053_가장긴증가하는부분수열{
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[][] dp = new int[input+1][2];
        int result = 1;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for (int i=0; i<input; i++){
            dp[i][0]=1;
            dp[i][1]=Integer.parseInt(st.nextToken());
            for (int j=0; j<i; j++){
                if(dp[i][1]>dp[j][1]){
                    dp[i][0]=Math.max(dp[i][0],dp[j][0]+1);
                }
                result = result<dp[i][0]? dp[i][0] : result;
            }
        }

        System.out.println(result);

    }
    }

