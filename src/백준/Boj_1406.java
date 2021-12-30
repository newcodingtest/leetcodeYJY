package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Boj_1406 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = reader.readLine();
        int n = Integer.parseInt(reader.readLine());
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        StringBuilder sb =new StringBuilder();

        for(int i=0; i<s.length(); i++) //왼쪽 스택에 입력받은 문자열을 전부 넣는다.
            left.push(s.substring(i,i+1));


        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            String c = st.nextToken();
            switch(c) {
                case "L":
                    if(!left.isEmpty())
                        right.push(left.pop());
                    break;
                case "D":
                    if(!right.isEmpty())
                        left.push(right.pop());
                    break;
                case "B":
                    if(!left.isEmpty())
                        left.pop();
                    break;
                case "P":
                    left.push(st.nextToken());
                    break;
            }
        }

        while(!left.isEmpty()) //오른쪽 스택에 왼쪽 스택 옮기기
            right.push(left.pop());

        while(!right.isEmpty())
            sb.append(right.pop());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}

