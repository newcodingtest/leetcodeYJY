package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15721_번데기 {
    static int A,T;
    static String N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        N = br.readLine();
        makeSentence();
        System.out.println(bruteSearch());
    }

    public static void makeSentence(){
        while(sb.length()<=10000) {
            int cnt = 2;
            // 뻔 - 데 패턴 적용
            for (int j = 0; j < 4; j++) {
                if (sb.length() == 10000) {
                    return;
                }
                if (j % 2 == 0) {
                    sb.append("0");
                } else {
                    sb.append("1");
                }

            }
            //그 이후 패턴 적용
            for (int i = 0; i < cnt; i++) {
                if (sb.length() == 10000) {
                    return;
                }
                sb.append("0");
            }
            for (int i = 0; i < cnt; i++) {
                if (sb.length() == 10000) {
                    return;
                }
                sb.append("1");
            }
            cnt++;
        }

    }

    public static int bruteSearch(){
        int cnt = 0;
        for (int i=0; i<=10000; i++) {
            if (String.valueOf(sb.charAt(i)).equals(N)) {
                cnt++;
            }
            if (cnt == T) {
                return i % A;
            }

        }
        return 0;
    }

}
