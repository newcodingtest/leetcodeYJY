package 프로그래머스.level1;

import java.util.Arrays;

public class 중앙값구하기 {
    public static int solution(int[] array) {
        int[] answer = Arrays.stream(array).sorted().toArray();
        return answer[answer.length/2];
    }
}
