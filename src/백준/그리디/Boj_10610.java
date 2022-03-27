package 백준.그리디;

import java.io.*;
import java.util.Arrays;

public class Boj_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String target = br.readLine();

        char[] arr = target.toCharArray();

        Arrays.sort(arr);

        int sum = 0;
        for (int i=arr.length-1; i>=0; i--){
            int temp = arr[i]-'0';
            sum+=temp;
            sb.append(temp);
        }

        if(arr[0]!='0' || sum%3!=0){
            System.out.println(-1);
            return;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
