package 프로그래머스.level1;


public class 가운데글자가져오기 {
    public static String solution(String s) {
        String answer = s;
        int middle = answer.length()/2;
        if(odd(answer)) {
            return answer.substring(middle-1,middle+1);
        }else{
            return String.valueOf(answer.charAt(middle));
        }
    }

    public static boolean odd(String input) {
        if(input.length()%2==0) {
            return true;
        }
        return false;
    }
}
