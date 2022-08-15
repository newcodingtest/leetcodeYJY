package 백준.기본문제;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Boj2501_약수구하기 {
    static int CNT = 0;
    static List<Integer> list = new ArrayList<>();
    static int N,M;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for(int i=1; i<=N/2; i++) {
            valid(N, i);
        }
        list.add(N);
//		list.forEach(x -> {
//			System.out.println(x);
//		});
        int result = list.size()>=M?list.get(M-1):0;
        System.out.println(result);
    }

    public static void valid(int target, int i) {
        if(target%i==0) {
            list.add(i);
        }
    }
}
