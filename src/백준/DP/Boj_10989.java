package 백준.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Boj_10989 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i=0; i<n; i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for (int i=0; i<n; i++){
            sb.append(arr[i]+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
