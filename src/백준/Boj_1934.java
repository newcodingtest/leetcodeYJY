package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_1934 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        while(count-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            Long a = Long.parseLong(st.nextToken());
            Long b = Long.parseLong(st.nextToken());

            long c = GCD(a, b);
            sb.append(a * b / c).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static long GCD(Long a, Long b){
        while(b!=0){
            long r = a % b;
            a=b;
            b=r;
        }
        return a;
    }
}
