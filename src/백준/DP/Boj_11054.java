package 백준.DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Boj_11054 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[][] arr = new int[n+1][4];

        for(int i=1; i<=n; i++) {
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=1;
            arr[i][2]=1;
        }


        for (int i = 1; i <=n; i++) {
            for (int j = 1; j < i; j++) {
                if(arr[i][0]>arr[j][0]) {
                    arr[i][1]=Math.max(arr[i][1], arr[j][1]+1);
                }
                if(arr[arr.length-j][0]<arr[arr.length-i][0]) {
                    arr[arr.length-i][2]=Math.max(arr[arr.length-i][2], arr[arr.length-j][2]+1);
                }
            }
        }
        int max = 0;

        for (int i = 1; i <= n; i++) {
            if(max<arr[i][1]+arr[i][2]) {
                max=arr[i][1]+arr[i][2];
            }
        }

        System.out.println(max-1);
    }

}
