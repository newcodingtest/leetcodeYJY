import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("\\*");
        String regex = "^"+input[0]+".*"+input[1]+"$";
        Pattern pattern = Pattern.compile(regex);

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<cnt; i++){
            Matcher matcher = pattern.matcher(br.readLine());
            if (matcher.find()){
                sb.append("DA").append(System.lineSeparator());
            } else {
                sb.append("NE").append(System.lineSeparator());
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}