package 프로그래머스.level1;


public class 최대공약수_최소공배수 {
    public static void main(String[] args){

    }

    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        answer[0]= GCD(n,m);
        answer[1]= LCM(n,m);

        return answer;
    }

    //최대 공약수
    public static int GCD(int n, int m){
        if(m == 0) return n;
        return GCD(m, n%m);
    }

    //최대 공배수
    public static int LCM(int n, int m){
        return (n*m)/GCD(n,m);
    }

}
