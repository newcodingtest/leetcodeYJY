import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++){
            String s = br.readLine();
            solution(s);
        }
        list.sort((o1, o2) -> o1.length()==o2.length()?o1.compareTo(o2):o1.length()-o2.length());

        list.stream().forEach(x -> {
            System.out.println(x);
        });

    }
    //65~90 : A-Z, 97~122: a-z
    public static void solution(String s){
        Pattern pattern = Pattern.compile("\\d+");

        Matcher matcher = pattern.matcher(s);

        while(matcher.find()){
            String str = matcher.group().replaceAll("^0+","");
            String target = str.length()==0?"0":str;
            list.add(target);
        }
    }
}