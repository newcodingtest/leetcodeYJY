import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_10430 {
    static long a,b,c;
    static StringBuilder sb;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        sb = new StringBuilder();
        a=Long.parseLong(st.nextToken());
        b=Long.parseLong(st.nextToken());
        c=Long.parseLong(st.nextToken());

        one(a,b,c);
        two(a,b,c);
        three(a,b,c);
        four(a,b,c);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void one(long x, long y, long z){
        sb.append((x+y)%z +"\n");
    }
    public static void two(long x, long y, long z){
        sb.append((a%c + b%c)%c +"\n");
    }
    public static void three(long x, long y, long z){
        sb.append((a*b)%c +"\n");
    }
    public static void four(long x, long y, long z){
        sb.append((a%c * b%c)%c +"\n");
    }
}
