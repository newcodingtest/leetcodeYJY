package 백준.이분탐색;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj1991_트리순회 {
    static Map<String,List<String>> map = new HashMap<String, List<String>>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        for(int i=0; i<cnt; i++) {
            List<String>son = new ArrayList<String>();
            String[] node = br.readLine().split(" ");

            son.add(node[1]);
            son.add(node[2]);

            map.put(node[0], son);
        }
        preOrder("A"); System.out.println();
        middleOrder("A"); System.out.println();
        postOrder("A");
    }

    public static void preOrder(String str) {
        if(str.equals(".")) {
            return;
        }
        System.out.print(str);
        preOrder(map.get(str).get(0));
        preOrder(map.get(str).get(1));
    }
    public static void middleOrder(String str) {
        if(str.equals(".")) {
            return;
        }
        middleOrder(map.get(str).get(0));
        System.out.print(str);
        middleOrder(map.get(str).get(1));
    }
    public static void postOrder(String str) {
        if(str.equals(".")) {
            return;
        }
        postOrder(map.get(str).get(0));
        postOrder(map.get(str).get(1));
        System.out.print(str);
    }

}
