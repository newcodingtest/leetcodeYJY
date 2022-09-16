package 백준.이분탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2295 {
    static int[] arr;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr =new int[n];

        for(int i = 0;i<n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
       arr= Arrays.stream(arr).distinct().sorted().toArray();

        for (int i= arr.length-1; i>=0; i--){
            if (binarySearch(arr[i])){
                System.out.println("i = " + i);
                break;
            }
        }

    }

    public static boolean binarySearch(int target){

        int start = arr.length-3;
        int end = arr.length-1;

        while((start+2)==end){
            int tempSum = sum(start,end);

            if(target==tempSum){
                return true;
            }else{
                return false;
            }
        }
    return false;
    }

    public static int sum(int start, int end){
        int sum = 0;
        for(int i=start; i<end; i++){
            sum+=arr[i];
        }
        return sum;
    }
}
