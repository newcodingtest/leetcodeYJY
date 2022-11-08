package 프로그래머스.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 최대값과최소값 {
    public static void main(String[] args){
        String str1 = "1 2 3 4";
        String str2 = "-1 -2 -3 -4";
        String str3 = "-1 -1";

        System.out.println(solution(str2));
    }

    public static String solution(String s) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String str : s.split( " ")){
            list.add(Integer.parseInt(str));
        }
        Collections.sort(list);

        sb.append(list.get(0)+" ")
                .append(list.get(list.size()-1));
        return sb.toString();
    }
}
