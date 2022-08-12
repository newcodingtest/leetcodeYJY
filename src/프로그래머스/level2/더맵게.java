package 프로그래머스.level2;
import java.util.PriorityQueue;

public class 더맵게 {
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> p =new PriorityQueue<Integer>();
        for(int i : scoville) {
            p.add(i);
        }

        int cnt = 0;
        while(p.size()>1 && p.peek()<K) {
            int firstLow = p.poll();
            int secondLow = p.poll();
            cnt++;
            int temp = firstLow+(secondLow*2);

            p.add(temp);
        }

        if(p.size()<=1 && p.peek()<K) {
            cnt = -1;
        }

        return cnt;
    }
}
