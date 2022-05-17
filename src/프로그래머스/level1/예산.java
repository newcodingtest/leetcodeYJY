package 프로그래머스.level1;
import java.util.Arrays;

public class 예산 {
    public int solution(int[] d, int budget) {
        int[] temp = d;
        Arrays.sort(temp);
        int sum = 0;
        int cnt = 0;

        for(int i=0; i<temp.length; i++) {
            if(sum+temp[i]<=budget) {
                sum+=temp[i];
                cnt++;
            }
        }
        return cnt;
    }
}
