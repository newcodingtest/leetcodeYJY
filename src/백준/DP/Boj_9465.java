package 백준.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_9465 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int row = Integer.parseInt(br.readLine());

        for (int i = 0; i < row; i++) {
            int col = Integer.parseInt(br.readLine());

            // initialize
            int[][] stickers = new int[2][col+1];
            int[][] dp = new int[2][col+1];
            for(int j=0; j<2; j++){
                String[] inputs = br.readLine().split(" ");
                for (int k = 1; k <= col; k++) {
                    stickers[j][k] = Integer.parseInt(inputs[k-1]);
                }
            }

            // 첫번째 column은 자기 자신이 최대이므로 자기 자신으로 초기화
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for (int j = 2; j <= col; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + stickers[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + stickers[1][j];
            }

            System.out.println(Math.max(dp[0][col], dp[1][col]));
        }
    }
}
