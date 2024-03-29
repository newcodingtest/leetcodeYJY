package 프로그래머스.level2;


import java.util.Arrays;

class 기능개발 {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[100];

        int day = -1;

        for(int i=0; i<progresses.length; i++) {
            while(progresses[i]+(day*speeds[i])<100) {
                day++;
            }
            answer[day]++;
        }

        return Arrays.stream(answer).filter(i->i!=0).toArray();

    }
}
