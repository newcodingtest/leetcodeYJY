import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2743 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //65~90:A~Z 97~122:a~z

        String input = br.readLine();
        for (int i=0; i<input.length(); i++){
            if(!(input.charAt(i)>64 && input.charAt(i)<91) && !(input.charAt(i)>96 && input.charAt(i)<123)){
                return;
            }
        }
        System.out.println(input.length());

    }
}
