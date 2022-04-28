package 프로그래머스.level1;
import java.util.Arrays;
import java.util.Stack;

public class 나누어떨어지는숫자배열 {
    static Stack<Integer>s = new Stack<>();
    static int[] result;
    public static int[] solution(int[] arr, int divisor) {
        int[] answer = arr;

        if(divisor==1) {
            Arrays.sort(answer);
            return answer;
        }
        for(int element : answer) {
            if(element % divisor==0) {
                s.push(element);
            }
        }
        process();
        return result;
    }

    public static void process() {
        if(s.size()>0) {
            isNotEmpty();
        }else {
            isEmpty();
        }
    }
    public static void isNotEmpty() {
        result = new int[s.size()];
        int i=0;
        while(s.size()>0) {
            result[i]=s.pop();
            i++;
        }
        Arrays.sort(result);
    }

    public static void isEmpty() {
        result = new int[1];
        result[0]=-1;
    }
}
