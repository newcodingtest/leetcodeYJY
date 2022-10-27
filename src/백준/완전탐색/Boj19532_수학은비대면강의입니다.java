package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj19532_수학은비대면강의입니다 {
    static int[] a_f;
    static int a,b,c,d,e,f;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        for (int i=-999; i<=999; i++){
            for (int j=-999; j<=999; j++){
                if((a*i+b*j)==c && (d*i+e*j)==f){
                    System.out.println(i+" "+j);
                    break;
                }
            }
        }

    }



}
