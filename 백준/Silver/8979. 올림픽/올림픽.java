import java.io.*;
import java.util.*;

public class Main {
    static int[] sum;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int countryIndex = Integer.parseInt(st.nextToken())-1;

        sum = new int[N];
        int value = -1;
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken())-1;
            int gold = Integer.parseInt(st.nextToken())*3;
            int silver = Integer.parseInt(st.nextToken())*2;
            int copper = Integer.parseInt(st.nextToken());

            sum[idx] = gold+silver+copper;
            if (idx==countryIndex){
                value=sum[idx];
            }
        }
        Arrays.sort(sum);
        int rank = 1;
        for (int i=0; i<N; i++){
            if (sum[i]==value){
                System.out.println(rank);
                break;
            }
            rank++;
        }
    }
}
