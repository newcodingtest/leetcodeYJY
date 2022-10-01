package 백준.이분탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10816_1 {
    static int[] arr;
    public static void main(String[] args)throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    arr =new int[n];
    st =new StringTokenizer(br.readLine());

    for(int i = 0;i<n;i++) {
        arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

        Arrays.stream(arr).forEach(x -> {
            System.out.println("x = " + x);
        });
    int m = Integer.parseInt(br.readLine());
    st =new StringTokenizer(br.readLine());

    while(m-->0){
        int target = Integer.parseInt(st.nextToken());

        int up = upperCase(target);
        int low = lowerCase(target);
        System.out.println(up-low);
    }

    }

    public static int upperCase(int target){
        int start = 0;
        int end = arr.length-1;
        int mid = 0;

        while(start<=end){
            mid = (start+end+1)/2;
            //target보다 무조건 큰 자리를 찾아야한다. 그러므로 '>'
            if(arr[mid]>target){
                end=mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }

    public static int lowerCase(int target){
        int start = 0;
        int end = arr.length-1;
        int mid = 0;

        while(start<end){
            mid = (start+end)/2;
            //target이랑 같거나 작은 자리를 찾아야한다. 그러므로 '>='
            if(arr[mid]>=target){
                end=mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
}
