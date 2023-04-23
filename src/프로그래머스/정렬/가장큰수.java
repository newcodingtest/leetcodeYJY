package 프로그래머스.정렬;
import java.util.*;

public class 가장큰수 {

    public static String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        for (int i=0; i<numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, (o1, o2) ->
            (o2+o1).compareTo(o1+o2));

        if (str[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<str.length; i++){
            sb.append(str[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {6,10,2};

        System.out.println(solution(nums));
    }


}
