package 프로그래머스.level2;

import java.util.Arrays;

public class 카펫 {
    static int result;
    static int[] answer;
    public static void main(String[] args){

        Arrays.stream( solution(24,24))
                .forEach(x -> {
                    System.out.println(x);
                });
    }
    //조건 1. 가로 세로는 3이상 이다.
    //조건 2. 가로>=세로
    //조건 3. 노란색의 (가로+2)*(세로+2)= 갈색의 수+노란색의 수
    public static int[] solution(int brown, int yellow) {
        answer = new int[2];
        result = brown+yellow;

        //
        for (int i=1; i<=yellow; i++){
            if(yellow%i==0){
                if(yellow/i>=i){
                    if(calculate(yellow/i,i)){
                        break;
                    }
                }
            }
        }
        return answer;
    }
    public static boolean calculate(int x, int y){
        if(x+2<3 || y+2<3){
            return false;
        }

        int sum = (x+2)*(y+2);
        if(sum==result){
            answer[0]=x+2;
            answer[1]=y+2;
            return true;
        }

        return false;
    }
}
