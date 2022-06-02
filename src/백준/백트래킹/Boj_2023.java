package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj_2023 {
    static int length;
    static ArrayList<Integer> arr = new ArrayList<Integer>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));

        length = Integer.parseInt(br.readLine());

        backTracking();

        arr.stream().forEach(i-> System.out.println(i));

    }

    //소수: 1보다 큰 자연수 중에서 1과 자신만을 약수로 가지는 수=? 2 3 5 7
    public static void backTracking() {
        for(int i=2; i<=9; i++) {
            if(i==2 || i==3 || i==5 || i==7) {
                checkDemical(i);
            }

        }
    }
    //재귀함수
    public static void checkDemical(int n) {
        //자릿수가 아직 4미만이면 재귀 진행
        if(String.valueOf(n).length()<length) {
            for(int i=0; i<=9; i++) {
                if(check(10*n+i)) {
                    checkDemical(10*n+i);
                }
            }
        }else if(String.valueOf(n).length()==length) {
            arr.add(n);
        }
    }

    //소수판별기
    public static boolean check(int n) {
        if (n <= 1) return false;    // 1은 소수가 아니다.
        if (n <= 3) return true;    // 2와3은 소수이다.
        if (n % 2 ==0) return false;
        for(int i = 3; i <= Math.sqrt(n); i+=2) {
            if(n % i == 0) return false;
        }
        return true;
    }



}