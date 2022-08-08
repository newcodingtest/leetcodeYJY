package 백준;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1789_수들의합 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        System.out.println(test(N));
    }

    public static int test(Long input) {
        long sum = 0;
        int temp = 0;
        for(int i=1; ; i++) {
            if(sum>input) {
                break;
            }
            sum+=i;
            temp++;
        }
        return temp-1;
    }
}
