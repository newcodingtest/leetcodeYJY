package 백준;

import sun.misc.GC;

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
            int c =Integer.parseInt(input[0]);

            int[] arr = new int[c];
            for (int i = 0; i< arr.length; i++){
                arr[i]=Integer.parseInt(input[i+1]);
            }
            long result = 0;
            for (int i = 0; i< arr.length-1; i++){
                for (int j = i+1; j< arr.length; j++){
                    result+=GCD(arr[i],arr[j]);
                }
            }
            bw.write(result+"\n");
        }
        bw.flush();
        bw.close();
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
