package 백준.문자열;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj9252_LCS2 {
    static int[][] dp;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        dp = new int[str1.length()+1][str2.length()+1];

        LCS(str1,str2);
    }

    public static void LCS(String input1, String input2) {
        dp[0][0]=0;
        for (int i = 1; i <= input1.length(); i++) {
            for(int j = 1; j <= input2.length(); j++) {
                if(input1.charAt(i-1)==input2.charAt(j-1)) {
                    dp[i][j]= dp[i-1][j-1]+1;

                }else {
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[input1.length()][input2.length()]);
        LCS_String(input1, input2);
    }

    //ACAK
    public static void LCS_String(String input1, String input2) {
        StringBuffer sb = new StringBuffer();
        int x = input1.length();
        int y = input2.length();

        while(x!=0 && y!=0) {

            if(input1.charAt(x-1)==input2.charAt(y-1)) {
                sb.append(input1.charAt(x-1));
                x--;
                y--;
            }
            else if(dp[x][y]==dp[x-1][y]) {
                x--;
            }else if(dp[x][y]==dp[x][y-1]) {
                y--;
            }


        }
        System.out.println(sb.reverse());

    }
}
