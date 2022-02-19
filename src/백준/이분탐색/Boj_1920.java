package 백준.이분탐색;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1920 {
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
            boolean check = binarySearch(arr,target);
            if(check) {
                sb.append(1+"\n");
            }else if(!check){
                sb.append(0+"\n");
            }
            }
        System.out.println(sb.toString());
    }
    public static boolean binarySearch(int[] targetArr, int target){
        int start = 0;
        int end = targetArr.length-1;
        int mid = 0 ;
        while(start<=end){
            mid = (start+end)/2;
            if(arr[mid]==target){
                return true;
            }else if(arr[mid]<target){
                start = mid+1;
            }else if(arr[mid]>target){
                end = mid -1;
            }
        }

        return false;
    }
}
