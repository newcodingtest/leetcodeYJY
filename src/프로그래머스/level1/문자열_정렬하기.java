package 프로그래머스.level1;

public class 문자열_정렬하기 {
    public static String solution(String my_string) {
        //1. 소문자로 변환
        char[] target = my_string.toLowerCase().toCharArray();

        //2. 알파벳 순서로 정렬
        for (int i=0; i< target.length; i++){
            for (int j=0; j<target.length; j++){
                if(i==j) continue;

                if((target[i]-'a')<(target[j]-'a')){
                    char temp = target[j];
                    target[j]=target[i];
                    target[i]= temp;
                }
            }

        }
        return new String(target);
    }
}
