package 백준.이분탐색;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2512_예산 {
    static int[] budgets;
    static int total;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        budgets = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }
        total = Integer.parseInt(br.readLine());
        Arrays.sort(budgets);

        divide_2(0, n-1);
    }

    public static void divide_2(int low,int high) {

        int left = 0;
        int right = budgets[high];
        int result = 0;

        while(left<=right) {
            int middle = (left+right)/2;
            long sum=0;
            for(int num : budgets) {
                if(num>middle) {
                    sum+=middle;
                }else {
                    sum+=num;
                }
            }

            if(sum>total) {
                right = middle-1;
            }else {
                left = middle+1;
                result = Math.max(result, middle);
            }
        }
        System.out.println(result);
    }
}
