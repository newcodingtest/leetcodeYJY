package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj18312_시각 {
    static int N;
    static int K;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for(int h=0; h<=N; h++){
            for(int m=0; m<=59; m++){
                for(int s=0; s<=59; s++){
                    if (check(h,m,s)){
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);

    }

    public static boolean check(int h, int m, int s){
        if(h/10==K || h%10==K || m/10==K || m%10==K || s/10==K || s%10==K){
            return true;
        }
        return false;
    }
}
