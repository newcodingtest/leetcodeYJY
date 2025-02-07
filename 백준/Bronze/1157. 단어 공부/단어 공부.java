import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int MAX = Integer.MIN_VALUE;
    //최대 인원
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine().toUpperCase();

        System.out.println(solution(word));
    }

    public static String solution(String word){
        if (word.length()==1){
            return word;
        }

        int[] ascii = new int[26];
        for (int i=0; i<word.length(); i++){
            ascii[word.charAt(i)-'A']++;
        }

        int idx = -1;
        for (int i=0; i<ascii.length; i++){
            if (ascii[i]>MAX){
                idx=i;
                MAX = ascii[i];
            }
        }
        Arrays.sort(ascii);
        if (ascii[ascii.length-2]==MAX){
            return "?";
        }

        char ch = (char) (idx + 65); // 1을 'A'로 변환
        String result = String.valueOf(ch);
        return result;
    }
}
