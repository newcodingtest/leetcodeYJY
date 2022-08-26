package 프로그래머스.level2;

public class _124의나라 {
    static String[] nara = {"4","1","2"};
    static StringBuilder sb = new StringBuilder();
    public static String solution(int n) {
        while(n>0) {
            System.out.println(n);
            sb.append(nara[n%3]);
            n=(n-1)/3;
        }
        return sb.reverse().toString();
    }
}
