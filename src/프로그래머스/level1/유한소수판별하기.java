package 프로그래머스.level1;

public class 유한소수판별하기 {
    public int solution(int a, int b) {
        int target =  b/gcd(a,b);

        while(target!=1){
            if (target%2==0){
                target/=2;
            } else if(target%5==0){
                target/=5;
            } else {
                //무한 소수
                return 2;
            }
        }
        //유한소수
        return 1;
    }

    public static int gcd(int a, int b){
        if(b==0){
            return a;
        } else {
            return gcd(b,a%b);
        }
    }
}
