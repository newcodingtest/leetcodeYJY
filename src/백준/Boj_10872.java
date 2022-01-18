package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_10872 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(0>=n){
            System.out.println(1);
        }else{
            int result = 1;
            for (int i = 1; i<=n; i++) {
                result*=i;
            }
            System.out.println(result);

        }

    }
}
