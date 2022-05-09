package 프로그래머스.level1;

public class 나머지가1이되는수찾기 {
    public static int solution(int n) {
        int result = 0;
        for(int i=1; i<1000000; i++){
            if(n%i==1){
                result = i;
                break;
            }
        }
        return result;
    }
}
