import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Integer> cache = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
       public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //돌을 1개 또는 3개를 가져갈 수 있음.
        //완벽? 나누고 몫이 짝수고, 나머지가 있어야 마지막에 내 차례이다.
        int N = Integer.parseInt(br.readLine());
        
        if (N%2==0){
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}