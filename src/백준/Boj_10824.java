package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_10824 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        long odd=Long.parseLong(input[0]+input[1]);
        long even=Long.parseLong(input[2]+input[3]);

        sb.append(odd+even);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
