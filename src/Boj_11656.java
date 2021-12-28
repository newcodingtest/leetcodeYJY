import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Boj_11656 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String[] arr = new String[input.length()];

        for (int i=0; i<input.length(); i++){
            for (int j = i; j<input.length(); j++){
                arr[i]+=input.charAt(j);
            }
        }
        Arrays.sort(arr);
       for(int i=0; i<arr.length; i++){
           System.out.println(arr[i].replace("null",""));
       }
    }
}
