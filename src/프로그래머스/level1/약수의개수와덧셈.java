package 프로그래머스.level1;

import java.util.ArrayList;
import java.util.List;

public class 약수의개수와덧셈 {
    static List<Integer> divide;
    public static void main(String[] args){

        int left = 24;
        int right = 27;

        solution(left,right);
    }

    /**
     *  left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고,
     *  약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
     * */
    public static int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++){
            if(check(i)%2==0){
                answer+=i;
            }else{
                answer-=i;
            }
        }
        return answer;
    }

    public static int check(int n){
        divide = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(n%i==0){
                divide.add(i);
            }
        }
        return divide.size();
    }
}
