import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] money;
    static long MAX = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        money = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            money[i] = Integer.parseInt(st.nextToken());
        }

        int windowSize = 0;
        long sum = 0;
        int start = 0;
        int end = 0;
        for (int i=0; i<=n-m; i++){
            while(windowSize<m) {
                sum += money[end];
                end++;
                windowSize++;
            }
            MAX = Math.max(MAX, sum);
            sum-=money[start];
            start++;
            windowSize--;
        }
        System.out.println(MAX);
    }
}
