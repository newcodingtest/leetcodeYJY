import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_1850 {
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
