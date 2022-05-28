package 프로그래머스.level1;

import java.util.Arrays;


public class 완주하지_못한_선수 {

    public static void main(String[] args){
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(solution(participant,completion));

    }

    public static String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        int i=0;
        for (i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                break;
            }
        }

        return participant[i];
    }
}
