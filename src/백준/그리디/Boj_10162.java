package 백준.그리디;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Boj_10162 {

        static int[] dp = new int[3]; //0: 300, 1: 60, 2:10
        public static void main(String[] args)throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());

            if(divide_300(n)>0) {
                System.out.println(-1);
            }else {
                for(int temp : dp) {
                    System.out.print(temp+" ");
                }
            }
            ;
        }
        public static int divide_300(int n) {
            int temp = n;
            while(temp>=300) {
                int divide = temp/300;
                temp = temp%300;
                dp[0]=dp[0]+divide;
            }
            while(temp>=60) {
                int divide = temp/60;
                temp = temp%60;
                dp[1]=dp[1]+divide;
            }
            while(temp>=10) {
                int divide = temp/10;
                temp = temp%10;
                dp[2]=dp[2]+divide;;
            }
            return temp;
        }

}
