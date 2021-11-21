package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_1003_2 {
    static int zero=0;
    static int one=0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while(n-->0){
            int m = Integer.parseInt(br.readLine());

            finonacchi(m);
            System.out.println(zero+" "+one);
            zero=0;
            one=0;
        }
    }
    static void finonacchi(int m){
        if(m==0){
            zero++;
        }else if(m==1){
            one++;
        }else if(m<0){
            return;
        }
        finonacchi(m-1);
        finonacchi(m-2);
    }
}
