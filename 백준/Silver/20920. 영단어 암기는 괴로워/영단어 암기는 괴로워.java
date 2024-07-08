import java.io.*;
import java.util.*;
public class Main {
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        for (int i=0; i<count; i++){
            String str = br.readLine();
            if (str.length()>=limit){
                map.put(str, map.getOrDefault(str,0)+1);
            }
        }

        List<String>alpabet = new ArrayList<>(map.keySet());
        alpabet.sort((o1, o2) -> {

            int freq = map.get(o2).compareTo(map.get(o1));
            if (freq==0){
                int len = o2.length()-o1.length();
                //3.알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
                if(len==0){
                    return o1.compareTo(o2);
                }
                //2.해당 단어의 길이가 길수록 앞에 배치한다.
                return len;
            }
            //1.자주 나오는 단어일수록 앞에 배치한다.
            return freq;
        });

        for (String alpa : alpabet){
            bw.write(alpa+"\n");
        }
        bw.flush();
        bw.close();
    }
}