package 백준.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Boj9342_염색체 {
    private static final Pattern xy = Pattern.compile(
            "^[A-F]?A+F+C+[A-F]?$");

    static boolean check(String s) {
        return xy.matcher(s).matches();}

        public static void main(String[] args)throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int cnt = Integer.parseInt(br.readLine());

            for(int i=0; i<cnt; i++) {
                String str = br.readLine();
                if(check(str)) {
                    System.out.println("Infected!");
                }else if(!check(str)) {
                    System.out.println("Good");
                }
            }
        }



    }

