import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] alpabet;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        alpabet = new boolean[52][52];

        for (int i=0; i<N; i++){
            String str = br.readLine();
            char start = str.charAt(0);
            char end = str.charAt(5);

            alpabet[alpabetToInt(start)][alpabetToInt(end)] = true;
        }

          for (int i=0; i<52; i++){
            for (int j=0; j<52; j++){
                for (int k=0; k<52; k++){
                    if(alpabet[j][k]) continue;
                    if (j==k || j==i || i==k || alpabet[j][k]) continue;
                    if(alpabet[j][i] && alpabet[i][k]){
                        alpabet[j][k]=true;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
             int cnt = 0;
        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < 52; j++) {
                if(i==j){continue;}
                if(alpabet[i][j]){
                           cnt++;
                    sb.append(intToAlpabet(i)).append(' ').append('=').append('>').append(' ').append(intToAlpabet(j)).append('\n');
                }
            }
        }
      System.out.println(cnt);
       System.out.println(sb.toString());
    }

    public static int alpabetToInt(char c){

        //대문자
        if (Character.isUpperCase(c)){
            return (c-65);
        }
        //소문자
        return (c-'a')+26;
    }

    public static String intToAlpabet(int i){
        //대문자
        if(i<26){
            return Character.toString(65+i);
        }
        //소문자
        return Character.toString(71+i);
 
    }

}

