package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_9613 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        while(n-->0){
            String[] input = br.readLine().split(" ");
            for (int i=1; i<input.length; i++){
                int r=GCD(Integer.parseInt(input[i-1]),Integer.parseInt(input[i]));
                int temp =
                for (int j=1; j<input.length; j++){

                }
            }
        }
    }

    public static int GCD(int a, int b){
        while(b!=0){
            int r = a % b;
            a=b;
            b=r;
        }
        return a;
    }
}
