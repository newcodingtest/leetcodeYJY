import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static Set<String> set = new HashSet<>();
    static String str = "";
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        isVisited = new boolean[str.length()];
        for (int i=0; i<str.length(); i++){
            dfs(str.charAt(i)+"", i);
        }
        System.out.println(set.size());
    }

    public static void dfs(String target, int start){
        set.add(target);
        if (str.length()-1<=start){
            return;
        }
        dfs(target+str.charAt(start+1), start+1);
    }
}

