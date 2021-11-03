package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Boj_2108 {
    //평군 구하는 함수
    static int avg(int[] arr){
        double sum=0;
        double result =0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
        }
        result = Math.round(sum/arr.length);
        return (int)Math.ceil(result);
    }
    //중앙 값 출력
    static int middle(int[] arr){
        return arr[arr.length/2];
    }


    //최빈 값 출력
    static int many(int[] arr) {
        int[] target = new int[8001];
        ArrayList<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for (int x : arr) {
            if (0 > x) {
                target[4000 + Math.abs(x)]++;
            } else {
                target[x]++;
            }
        }
            int temp = 0;
            for (int i = 0; i < target.length; i++) {
                if (target[i] != 0 && target[i] > max) {
                    max = target[i];
                    temp = i;
                }
            }

            for (int i = 0; i < target.length; i++) {
                int minusValue = i;
                if (max == target[i]) {
                    if (i > 4000) {
                        minusValue -= 4000;
                        minusValue *= -1;
                        list.add(minusValue);
                    } else {
                        list.add(i);
                    }
                }
            }

            Collections.sort(list);
            if (list.size() > 1) {
                return list.get(1);
            } else {
                return list.get(0);
            }

         }

    static int range(int[] arr){

        return arr[arr.length-1]-arr[0];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] target = new int[n];

        for(int i=0; i<n; i++){
            target[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(target);

        System.out.println(avg(target));
        System.out.println(middle(target));
        System.out.println(many(target));
        System.out.println(range(target));
    }


}
