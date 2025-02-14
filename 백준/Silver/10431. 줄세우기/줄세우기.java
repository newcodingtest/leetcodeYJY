import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++){
            int[] arr = new int[20];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            for (int j=0; j<20; j++){
                int test = Integer.parseInt(st.nextToken());
                arr[j] = test;
            }
            move(arr, index);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void move(int[] arr, int index) {
        int cnt = 0;
        for (int i=19; i>=0; i--){
            for (int j=i-1; j>=0; j--){
                if (arr[i]<arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    cnt++;
                }
            }
        }
        sb.append(index+" ").append(cnt+"\n");
    }
}