import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[][] alpabet;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i=0; i<n; i++){
            String str = br.readLine();
            alpabet = new int[26][2];
            if (spellCheck(str)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static boolean spellCheck(String str){
        for (int i=0; i<str.length(); i++){
            //아직 방문 안했을때
            if (alpabet[str.charAt(i)-'a'][1]==0){
                alpabet[str.charAt(i)-'a'][0] = i;
                alpabet[str.charAt(i)-'a'][1] = 1; //방문
            }
            //방문 했을때
            else {
                //주변에 없다면
                int distance = Math.abs(i-alpabet[str.charAt(i)-'a'][0]);
                if (distance>1){
                    return false;
                }
                //주변에 있다면
                else {
                    alpabet[str.charAt(i)-'a'][0] = i;
                }
            }
        }
        return true;
    }


}

