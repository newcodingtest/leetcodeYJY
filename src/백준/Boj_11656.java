package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11656 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String[] arr = new String[input.length()];

        for (int i=0; i<input.length(); i++){
            for (int j = i; j<input.length(); j++){
                arr[i]+=input.charAt(j);
            }
        }
        Arrays.sort(arr);
       for(int i=0; i<arr.length; i++){
           System.out.println(arr[i].replace("null",""));
       }
    }

    public static class Boj_1850 {
        public static void main(String[] args)throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            StringBuilder sb = new StringBuilder();

            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            long c=GCD(a,b);

            while(c-->0){
                sb.append(1);
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }
        public static long GCD(long a, long b){
            while(b!=0){
                long r = a%b;
                a=b;
                b=r;
            }
            return a;
        }
    }
}
