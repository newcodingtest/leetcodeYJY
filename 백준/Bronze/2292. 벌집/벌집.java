import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //최대 인원
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(solution(N));
    }

    public static int solution(int num){
   
        int numbers = 2;
        int cnt = 1;
        while(numbers<=num){
            numbers+=(6*cnt);
            cnt++;
        }
        return cnt;


    }
}