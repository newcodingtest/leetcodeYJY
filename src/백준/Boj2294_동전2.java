package 백준;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Boj2294_동전2 {
    static int N, M;
    static int[] dp;
    static int[] arr;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int[M+1];

        for(int i=0; i<N; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0]=0;

        doDp();
        if(dp[M]==Integer.MAX_VALUE-1) {
            System.out.println(-1);
        }else {
            System.out.println(dp[M]);
        }

    }

    public static void doDp() {
        for(int i=0; i<N; i++) {
            for(int j=arr[i]; j<=M; j++) {
                dp[j] = Math.min(dp[j],dp[j-arr[i]]+1);
            }
        }
    }

}
