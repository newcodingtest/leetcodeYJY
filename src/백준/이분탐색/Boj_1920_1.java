package 백준.이분탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//라이브러리 이용해서 풀기
public class Boj_1920_1 {
    static int[] arr;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(m-->0){
            int target = Integer.parseInt(st.nextToken());
            boolean check = false;
            if(Arrays.binarySearch(arr,target)>=0) {
                sb.append(1+"\n");
                check =true;
            }
            if(!check){
                sb.append(0+"\n");
            }
        }
        System.out.println(sb.toString());
    }

}
