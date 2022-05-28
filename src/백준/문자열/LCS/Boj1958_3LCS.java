package 백준.문자열.LCS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Boj1958_3LCS {
    static String first;
    static String second;
    static String third;
    static int[][][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        first = br.readLine();
        second = br.readLine();
        third = br.readLine();

        dp = new int[first.length()+1][second.length()+1][third.length()+1];

        for(int i=1; i<=first.length(); i++) {
            char f = first.charAt(i-1);

            for(int j=1; j<=second.length(); j++) {
                char s = second.charAt(j-1);

                for(int k=1; k<=third.length(); k++) {
                    char t = third.charAt(k-1);

                    if(f==s && s==t) {
                        dp[i][j][k] = dp[i-1][j-1][k-1]+1;
                    }else {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
                    }
                }
            }
        }
        System.out.println(dp[first.length()][second.length()][third.length()]);

    }
}
