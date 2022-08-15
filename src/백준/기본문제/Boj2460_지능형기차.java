package 백준.기본문제;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Boj2460_지능형기차 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        dp = new int[11];

        dp[0]=0;
        int result = 0;
        for(int i=1; i<=10; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            dp[i] = y-x+dp[i-1];
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}
