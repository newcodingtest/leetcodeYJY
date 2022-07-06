package 프로그래머스.level1;

public class 문자열다루기기본 {
    static Pattern pattern = Pattern.compile("^\\d{4}|\\d{6}");
    public boolean solution(String s) {
        Matcher macher = pattern.matcher(s);
        return macher.matches();
    }
}
