package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//dp를 사용한 방법
public class Boj14501_퇴사_2 {
    static int N;
    static int[] dp;
    static int[] t;
    static int[] p;
    static int MAX = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        dp = new int[N+15];
        t = new int[N+15];
        p = new int[N+15];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        memorization();

        System.out.println(MAX);

    }

    private static void memorization() {
        for (int i=0; i<=N; i++){
            dp[i]=Math.max(MAX,dp[i]);
            dp[t[i]+i] = Math.max(dp[t[i]+i], p[i]+dp[i]);
            MAX = Math.max(MAX,dp[i]);
        }
    }


}
