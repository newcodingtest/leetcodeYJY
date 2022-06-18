package 백준.문자열;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;
public class Boj_2491수열 {
    static int[] dp;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        dp = new int[cnt];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<cnt; i++) {
            dp[i]=Integer.parseInt(st.nextToken());
        }

        int max = 1;
        int increase = 1;
        int decrease = 1;

        for(int i=0; i<dp.length-1; i++) {
            if(dp[i]<=dp[i+1]) {
                increase++;
            }else {
                increase=1;
            }
            max = Math.max(max, increase);
        }

        for(int i=0; i<dp.length-1; i++) {
            if(dp[i]>=dp[i+1]) {
                decrease++;
            }else {
                decrease=1;
            }
            max = Math.max(max, decrease);
        }
        System.out.println(max);
    }
    }

