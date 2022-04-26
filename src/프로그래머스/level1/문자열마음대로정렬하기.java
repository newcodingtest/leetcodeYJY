package 프로그래머스.level1;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열마음대로정렬하기 {
    public String[] solution(String[] strings, int n) {
        String[] answer = strings;

        Arrays.sort(answer);

        Arrays.sort(answer,new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.charAt(n)-o2.charAt(n);
            };
        });
        return answer;
    }
}
