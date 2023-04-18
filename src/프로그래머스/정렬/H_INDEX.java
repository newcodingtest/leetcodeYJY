package 프로그래머스.정렬;

import java.util.Arrays;

public class H_INDEX {
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};

        solution(citations); //3
    }
    public static int solution(int[] citations){
        int answer = 0;

        Arrays.sort(citations);

        int length = citations.length;
        for (int i=0; i<length; i++){
            int min = Math.min(length-i,citations[i]);
            if(answer<min)answer=min;
        }

        System.out.println(answer);
        return answer;
    }
}
