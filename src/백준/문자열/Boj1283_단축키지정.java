package 백준.문자열;
//1.  먼저 하나의 옵션에 대해 왼쪽에서부터 오른쪽 순서로 단어의 첫 글자가 이미 단축키로 지정되었는지 살펴본다. 만약 단축키로 아직 지정이 안 되어있다면 그 알파벳을 단축키로 지정한다.
//2.  만약 모든 단어의 첫 글자가 이미 지정이 되어있다면 왼쪽에서부터 차례대로 알파벳을 보면서 단축키로 지정 안 된 것이 있다면 단축키로 지정한다.
//3.  어떠한 것도 단축키로 지정할 수 없다면 그냥 놔두며 대소문자를 구분치 않는다.
//4.  위의 규칙을 첫 번째 옵션부터 N번째 옵션까지 차례대로 적용한다.

//ArrayList vs Map 인덱스 찾는 속도차이
//https://nnoco.tistory.com/73

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Boj1283_단축키지정 {
    static Map<Character,Boolean> key = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    static String[] arr;
    static String[] result;
    static BufferedWriter bw;
    public static void main(String[] args)throws Exception{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        bw  = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        arr = new String[count];

        for (int i=0; i<count; i++){
            arr[i] = br.readLine();
        }
        check();

        for (String s : arr){
            System.out.println(s);
        }
        System.out.println(key.toString());
    }

    public static void check()throws Exception{
        for (int i=0; i<arr.length; i++){
            //2개의 단어면?
            if(arr[i].contains(" ")){
                twoWords(arr[i].split(" "),i);
            }else{
                oneWords(i);
            }
        }
    }

    //2개의 단어중 첫번째 글자가 키값인지 순회하자
    public static void twoWords(String[] two, int index)throws Exception{
        boolean isKey = false;
        String[] temp = two;
        for (int i=0; i<two.length; i++){
            //첫번째 자리가 키값이 아니면? 키값지정하고 ,[] 패턴 붙이기
            if(!key.containsKey(two[i].toLowerCase().charAt(0))){
                key.put(two[i].toLowerCase().charAt(0),true);
                isKey = true;
                temp[i] ="["+two[i].substring(0,1)+"]"+two[i].substring(1);
                isKey = true;
                break;
            }
        }
        arr[index]= String.join(" ",temp);

        //첫글자가 이미 단축키로 지정되어있으면, 순회하면서 등록이 안된것을 [] 패턴으로 만들고 키로 등록하자
        if(!isKey){
            for (int i=0; i<arr[index].length(); i++){
                if(arr[index].charAt(i) != ' '){
                    if(!key.containsKey(arr[index].toLowerCase().charAt(i))){
                        key.put(arr[index].toLowerCase().charAt(i),true);
                        arr[index] = arr[index].substring(0,i)+"["+arr[index].substring(i,i+1)+"]"+arr[index].substring(i+1);
                        break;
                    }
                }
            }
        }
    }

    public static void oneWords(int index)throws Exception{
        for (int i=0; i<arr[index].length(); i++){
            if(!key.containsKey(arr[index].toLowerCase().charAt(i))){
                key.put(arr[index].toLowerCase().charAt(i),true);
                arr[index] = arr[index].substring(0,i)+"["+arr[index].substring(i,i+1)+"]"+arr[index].substring(i+1);
                break;
            }
        }
    }

}
