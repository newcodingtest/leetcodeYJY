package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;


public class Boj_6588{
    static List<Integer> list;
    static boolean[] arr;
    static final int max = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new boolean[max+1];
        list = new ArrayList();
        arr[0]=arr[1]= true;

        for (int i = 2; i <=max; i++) {
            arr[i] = true;
        }

        for (int i = 2; i*i<=max; i++) {
            for (int j = i*i; j <=max; j+=i) {
                arr[j] = false;
            }
        }

        for (int i = 2; i <=max; i++) {
            if(arr[i]==true) {
                list.add(i);
            }
        }
        while (true) {
            int n = Integer.parseInt(br.readLine());
            check(n);

            if(n==0) {
                break;
            }

        }

    }

    public static void check(int input) {
        for (int i = 2; i <= input/2; i++) {
            if(arr[i] && arr[input-i]){
                System.out.println(input+" = "+i+" + " + (input-i));
                break;
            }
        }
    }

}
