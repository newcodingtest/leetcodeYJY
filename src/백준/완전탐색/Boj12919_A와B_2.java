package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj12919_A와B_2 {
    static String S,T;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        solve(T);
        System.out.println("0");
    }

    public static void solve(String str){
        if (str.length() == S.length()){
            if(str.equals(S)){
                System.out.println("1");
                System.exit(0);
            }
            return;
        }
        if(str.charAt(str.length()-1)=='A'){
            solve(str.substring(0,str.length()-1));
        }

        if(str.charAt(0)=='B'){
            StringBuilder sb = new StringBuilder(str.substring(1,str.length()));
            solve(sb.reverse().toString());
        }


    }
}
