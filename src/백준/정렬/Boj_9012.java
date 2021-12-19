package 백준.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class Boj_9012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(solve(br.readLine())+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static String solve(String input) {

        Stack<Character>stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char in = input.charAt(i);

            if(in == '('){
                stack.push(in);
            }else if(stack.empty()){
                return "NO";
            }else{
                stack.pop();
            }
        }

        if(stack.empty()){
            return "YES";
        }
        else{
            return "NO";
        }
    }
}
