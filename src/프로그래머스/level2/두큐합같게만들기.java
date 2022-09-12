package 프로그래머스.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {
    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer>q1 = new LinkedList<>();
        Queue<Integer>q2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;

        for(int num : queue1){
            q1.offer(num);
            sum1+=num;
        }
        for(int num : queue2){
            q2.offer(num);
            sum2+=num;
        }

        while(sum1!=sum2){
            if(sum1>sum2){
                int n = q1.poll();
                sum1-=n;
                sum2+=n;
                q2.offer(n);
                answer++;
            }else if(sum1<sum2){
                int n = q2.poll();
                sum1+=n;
                sum2-=n;
                q1.offer(n);
                answer++;
            }else if(sum1==sum2){
                break;
            }
            if(answer > 600000) return -1;
        }

        //만약 최대치 횟수를 초과했으면 -1을 출력
        return answer;
    }

    public static void main(String[] args){
        int[] q1_1={3,2,7,2};
        int[] q2_1={4,6,5,1};

        int[] q1_2={1,2,1,2};
        int[] q2_2={1,10,1,2};

        int[] q1_3={1,1};
        int[] q2_3={1,5};

        System.out.println(solution(q1_3,q2_3));
    }
}
