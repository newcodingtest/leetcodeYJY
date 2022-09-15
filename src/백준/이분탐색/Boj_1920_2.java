package 백준.이분탐색;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Boj_1920_2 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        //정렬
        Arrays.sort(arr);

        int M= Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++){
            int target=Integer.parseInt(st.nextToken());

            sb.append(binarySearch(target))
                    .append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int binarySearch(int target){
        int tempStart = 0;
        int tempEnd = arr.length-1;

        //start와 end가 서로 만나는 지점에서 target을 발견할수도 있기때문에
        //<=로 설정한다.
        while(tempStart<=tempEnd){
            int tempMid = (tempStart+tempEnd)/2;
            if(arr[tempMid]==target){
                return 1;
            }else if(arr[tempMid]>target){
                tempEnd=tempMid-1;
            }else if(arr[tempMid]<target){
                tempStart=tempMid+1;
            }
        }
        return 0;
    }
}
