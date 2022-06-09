package 백준.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj5251_LCS {
    static int[][] dp;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        dp = new int[str1.length()+1][str2.length()+1];
        LCS(str1,str2);
        System.out.println(dp[str1.length()][str2.length()]);
    }

    public static void LCS(String input1, String input2) {
        dp[0][0]=0;
        for (int i = 1; i <= input1.length(); i++) {
            for(int j = 1; j <= input2.length(); j++) {
                if(input1.charAt(i-1)==input2.charAt(j-1)) {
                    dp[i][j]= dp[i-1][j-1]+1;
                }else {
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }

        }

    }
}
