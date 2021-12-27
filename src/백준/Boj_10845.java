package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Boj_10845 {
    static Deque<String> queue = new LinkedList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int input = Integer.parseInt(br.readLine());

        for (int i= 0 ; i<input; i++){
            String[] inputArr = br.readLine().split(" ");

            calQueue(inputArr);
        }
    }

    public static void calQueue(String[] input){
        switch (input[0]){
            case "push":
                queue.offerFirst(input[1]);
                break;
            case "pop":
                if(queue.size()>1){
                    System.out.println(queue.removeLast());
                }else{
                    System.out.println(-1);
                }
                break;
            case "size":
                System.out.println(queue.size());
                break;
            case "empty":
                if(queue.isEmpty()==true){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
                break;
            case "front":
                if(queue.isEmpty()==true){
                    System.out.println(-1);
                }else {
                    System.out.println(queue.peekLast());
                }
                break;
            case "back":
                if(queue.isEmpty()==true){
                    System.out.println(-1);
                }else {
                    System.out.println(queue.peekFirst());
                }
                break;


        }
    }
}
