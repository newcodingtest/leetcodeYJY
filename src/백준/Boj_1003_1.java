package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Boj_1003_1 {
    static Integer[][] dp=new Integer[41][2];

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        dp[0][0]=1;
        dp[0][1]=0;
        dp[1][0]=0;
        dp[1][1]=1;

        while(n-->0){
            int m = Integer.parseInt(br.readLine());
            fibonacci(m);
            System.out.println(dp[m][0]+" "+dp[m][1]);
    }

    }
    static Integer[] fibonacci(int n){

       if(dp[n][0] == null  || dp[n][1] == null ){
           dp[n][0] = fibonacci(n-1)[0]+fibonacci(n-2)[0];
           dp[n][1] = fibonacci(n-1)[1]+fibonacci(n-2)[1];
       }

       return dp[n];
    }

    }


