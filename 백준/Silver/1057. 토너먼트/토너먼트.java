import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    static int N = 0;
    static int KIM = 0;
    static int IM = 0;
    static Set<Integer> set = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        KIM = Integer.parseInt(st.nextToken());
        IM = Integer.parseInt(st.nextToken());

        boolean isKimEven = false;
        boolean isImEven = false;

        Set<Integer> winners = new LinkedHashSet<>();
        Set<Integer> bye = new HashSet<>();
        IntStream.rangeClosed(1, N).forEach(n ->
                set.add(n)
        );

        int cnt = 1;
        while (true){
            winners.clear();
            List<Integer> participant = new ArrayList<>(set);
            int tmp = participant.size();
            int size = tmp%2==0?tmp:tmp-1;

            boolean isFind = false;
            for (int i=0; i<size; i+=2){
                int x1 = participant.get(i);
                int x2 = participant.get(i+1);

                if (x1==KIM || x1==IM){
                    winners.add(x1);
                    if (x2==KIM || x2==IM){
                        isFind = !isFind;
                        break;
                    }
                } else {
                    winners.add(x2);
                }
            }
            if (isFind){
                break;
            }
            if (tmp%2!=0){
                winners.add(participant.get(participant.size()-1));
            }
            set = new LinkedHashSet<>(winners);

            cnt++;
        }//while

        System.out.print(cnt);

    }



}

