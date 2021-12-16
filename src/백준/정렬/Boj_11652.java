package 백준.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11652 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        for (int i = 0; i< n; i++){
           arr[i]=Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        int cnt = 1;
        int max = 0;
        int idx = 0;
        for (int i = 1; i <n ; i++) {
            if(arr[i]==arr[i-1]){
                cnt++;
            }else{
                cnt=1;
            }
            if(cnt>max){
                max=cnt;
                idx=i;
            }
        }

        bw.write(arr[idx]+"\n");
        bw.flush();
        bw.close();
    }
}
