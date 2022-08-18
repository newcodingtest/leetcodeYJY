package 프로그래머스.level2;

public class 올바른괄호 {
    boolean solution(String s) {
        int cnt = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') {cnt++;}
            else { cnt--;}

            if(cnt<0) {return false;}
        }
        if(cnt!=0) {return false;}

        return true;
    }
}
