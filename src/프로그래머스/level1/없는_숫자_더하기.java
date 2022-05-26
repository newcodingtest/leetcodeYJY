package 프로그래머스.level1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 없는_숫자_더하기 {
    public static void main(String[] args){

        int[] num = {1,2,3,4,6,7,8,0};
        System.out.println(solution(num));
    }

    public static int solution(int[] numbers) {

        int sum = Arrays.stream(numbers).sum();

        return 45-sum;
    }
}
