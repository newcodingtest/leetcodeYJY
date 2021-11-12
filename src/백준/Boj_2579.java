package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2579 {
    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int[] arr = new int[input+1];
        int[] dp = new int[input+1];

        for(int i=1; i<=input; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1]=arr[1];
        if(input>2){
            dp[2] = arr[1]+arr[2];
        }

        for(int i=3; i<=input; i++){
            dp[i] = Math.max(dp[i-2],dp[i-3]+arr[i-1])+arr[i];
        }
        System.out.println(dp[input]);
    }

}
