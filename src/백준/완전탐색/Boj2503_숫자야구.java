package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj2503_숫자야구 {
    static int N;
    static int answer = 0;
    static List<Baseball> baseball = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
           baseball.add(new Baseball(st.nextToken(),Integer.parseInt(st.nextToken()) ,Integer.parseInt(st.nextToken())));
        }

        find();

        System.out.println(answer);

    }

    public static void find(){

        for (int i=123; i<=987; i++){
            if (!checkSameNum(i)) continue;

            int allPass = 0;
            for (int j=0; j<baseball.size(); j++){
                int strikeCnt = 0;
                int ballCnt = 0;


                Baseball bb = baseball.get(j);
                String nums = bb.numbers;
                int strike = bb.strike;
                int ball = bb.ball;

                String target = String.valueOf(i);
                    //strike 검사
                    for (int s=0; s<3; s++){
                        if(target.charAt(s)==nums.charAt(s)){
                            strikeCnt++;
                        }
                    }
                    //ball검사
                for (int b1=0; b1<3; b1++){
                    for (int b2=0; b2<3; b2++){
                        if(b1!=b2){
                            if(target.charAt(b1)==nums.charAt(b2)){
                                ballCnt++;
                            }
                        }

                    }
                }
                if (strikeCnt==strike && ballCnt==ball){
                    allPass++;
                }
            }
            //모든 조건에 만족하는 숫자를 찾음
            if(allPass==N){
                answer++;
            }
        }

    }


    static boolean checkSameNum(int num) {

        String numString = Integer.toString(num);

        if (numString.charAt(0) == numString.charAt(1)) {
            return false;
        }

        if (numString.charAt(1) == numString.charAt(2)) {
            return false;
        }

        if (numString.charAt(0) == numString.charAt(2)) {
            return false;
        }

        if (numString.charAt(0) == '0' || numString.charAt(1) == '0' || numString.charAt(2) == '0')
            return false;

        return true;
    }

    static class Baseball {
        String numbers;
        int strike;
        int ball;

        public Baseball(String numbers, int strike, int ball){
            this.numbers = numbers;
            this.strike = strike;
            this.ball = ball;
        }
    }
}
