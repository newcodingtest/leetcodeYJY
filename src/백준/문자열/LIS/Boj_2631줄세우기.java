package 백준.문자열.LIS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_2631줄세우기{
        static int[] arr;
        static int[] dp;
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int cnt = Integer.parseInt(br.readLine());
            arr = new int[cnt];
            dp = new int[cnt];

            for(int i=0; i<cnt; i++) {
                arr[i]= Integer.parseInt(br.readLine());
            }

            int max = 0;

            for(int i=0; i<arr.length; i++) {
                dp[i]=1;
                for(int j=0; j<i; j++) {
                    if(arr[i]>arr[j])
                        dp[i]=Math.max(dp[j]+1, dp[i]);
                }
                max = Math.max(max, dp[i]);
            }
            System.out.println(cnt-max);

        }
}
