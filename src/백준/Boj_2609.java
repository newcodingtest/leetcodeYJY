package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_2609 {
    static Stack<Integer> stack=new Stack<>();
    static Stack<Integer> stack1=new Stack<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int one = Integer.parseInt(st.nextToken());
        int two = Integer.parseInt(st.nextToken());

        int resultMax = gcd(one,two);//최대공약수
        int resultMin = one*two / resultMax;//최소공배수
        sb.append(resultMax+"\n"+resultMin);

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    //GCD 알고리즘 GCD(A,B) = GCD(B,A-B);

    public static int gcd(int a, int b) {

        while(b != 0) {
            int r = a % b;	// 나머지를 구해준다.

            // GCD(a, b) = GCD(b, r)이므로 변환한다.
            a = b;
            b = r;
        }
        return a;
    }
}
