import java.io.*;
import java.util.*;

public class Main {
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++){
            String[] str = br.readLine().split(" ");

            if (str.length>1){
                order(str[0], str[1]);
            } else {
                order(str[0], "");
            }

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void order(String operation, String num){
        switch (operation){
            case "add":
                set.add(num);
                break;
            case "check":
                if (set.contains(num)){
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
                break;
            case "remove":
                set.remove(num);
                break;
            case "toggle":
                if (set.contains(num)){
                    set.remove(num);
                } else {
                    set.add(num);
                }
                break;
            case "all":
                all(set);
                break;
            case "empty":
                set.clear();
                break;
        }
    }

    public static void all(Set<String> set){
        set.clear();
        for (int i=1; i<=20; i++){
            set.add(String.valueOf(i));
        }
    }
}