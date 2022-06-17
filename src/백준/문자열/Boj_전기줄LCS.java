package 백준.문자열;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Boj_전기줄LCS {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int N=Integer.parseInt(br.readLine());
        int[][]arr=new int[N][2];
        int[]dp=new int[N];



        for(int i=0; i<N; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr,new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                return x[0]-y[0];
            }
        });

        int max=1;
        for(int i=0; i<N; i++) {
            dp[i]=1;
            for(int j=0; j<i; j++) {
                if(arr[i][1]>arr[j][1]) dp[i]=Math.max(dp[i], dp[j]+1);
            }
            max=Math.max(dp[i], max);
        }
        bw.write(String.valueOf(N-max));

        bw.flush();
        bw.close();
    }
    }

