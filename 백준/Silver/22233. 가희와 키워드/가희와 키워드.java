import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int keywordCnt = Integer.parseInt(st.nextToken());
        int blogCnt = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> keywords = new HashMap<>();
        for (int i=0; i<keywordCnt; i++){
            keywords.put(br.readLine(), i);
        }

        for (int i=0; i<blogCnt; i++){
            String[] words = br.readLine().split(",");
            for (String word: words){
                keywords.remove(word);
            }
            sb.append(keywords.size()).append(System.lineSeparator());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}