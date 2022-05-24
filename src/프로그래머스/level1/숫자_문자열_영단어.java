package 프로그래머스.level1;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 숫자_문자열_영단어 {
    static Map<String,String> resultRank = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static int solution(String s) {
        doPutElements();

        return Integer.parseInt(solve(s));
    }

    public static void doPutElements() {
        resultRank.put("zero", "0");
        resultRank.put("one", "1");
        resultRank.put("two", "2");
        resultRank.put("three", "3");
        resultRank.put("four", "4");
        resultRank.put("five", "5");
        resultRank.put("six", "6");
        resultRank.put("seven", "7");
        resultRank.put("eight", "8");
        resultRank.put("nine", "9");
    }

    public static String solve(String s) {
        String temp = s;
        for(String compare : resultRank.keySet()) {
            Matcher mt = Pattern.compile(compare).matcher(temp);
            temp = mt.replaceAll(resultRank.get(compare));
        }
        return temp;
    }

}
