package 백준.이분탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1654 {
    static int[] arr;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        arr = new int[count];
        long max = 0;

        for (int i=0; i<count; i++){
            arr[i]=Integer.parseInt(br.readLine());
            if(arr[i]>max){
                max = arr[i];
            }
        }

        max++;
        long min = 0;
        long mid = 0;
        while(min < max){
            long modCnt = 0;
            mid = (max+min)/2;

            for (int i=0; i<count; i++){

               modCnt+=(arr[i]/mid);
            }

            if(modCnt<length){
                max = mid;
            }else {
                min = mid+1;
            }
        }
        System.out.println(min-1);

    }
}
