import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0;  i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = Integer.parseInt(br.readLine());
        for (int i=0; i<cnt; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            change(gender, start);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if ((i + 1) % 20 == 0 || i == arr.length - 1) {
                System.out.println();
            }
        }
    }

    //남자: 자기의 배수의 상태를 변경(1)
    //여자: 좌우 대칭이 같은대까지 찾아서 상태 변경(2)
    static void change(int gender, int start){
        if (gender==1){
            for (int i=1; i<=arr.length/start; i++){
                int idx = (start*i)-1;
                if (arr[idx]==1){
                    arr[idx]=0;
                } else {
                    arr[idx]=1;
                }
            }
        }
        else if(gender==2) {
            int end = Math.min(start-1, arr.length-start);
            if (arr[start-1]==1){
                arr[start-1]=0;
            } else {
                arr[start-1]=1;
            }

            for (int i=1; i<=end; i++){
                if(arr[(start-1)-i]==arr[(start-1)+i]){
                    if (arr[(start-1)-i]==1){
                        arr[(start-1)-i]=0;
                        arr[(start-1)+i]=0;
                    } else {
                        arr[(start-1)-i]=1;
                        arr[(start-1)+i]=1;
                    }
                } else {
                    break;
                }

            }
        }
    }
}
