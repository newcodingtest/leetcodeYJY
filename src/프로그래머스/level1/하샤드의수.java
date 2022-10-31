package 프로그래머스.level1;

public class 하샤드의수 {
    public static void main(String[] args){
        int n1 = 10;
        int n2 = 12;
        int n3 = 11;
        int n4 = 13;
        System.out.println(solution(n2));
    }

    public static boolean solution(int x) {
        int sum = 0;
        int temp = x;
        while(temp!=0){
            sum+=temp%10;
            temp/= 10;
        }
        return x%sum==0?true:false;
    }
}
