import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static List<Rank> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if (N==0){
            System.out.println(1);
            System.exit(0);
        }

        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            list.add(new Rank(Integer.parseInt(st.nextToken()),1));
        }

        Collections.sort(list);
        if (list.get(N-1).score==score){
            if (P<=N){
                System.out.println(-1);
                System.exit(0);
            }
        }
        list.add(new Rank(score,1));
        Collections.sort(list);
        for (int i=1; i<list.size(); i++){
            if (i>P-1){
                break;
            }
            int nowScore = list.get(i).score;
            int preScore = list.get(i-1).score;
            int preRank = list.get(i-1).rank;

            if (preScore>nowScore){
                list.get(i).rank=i+1;
            } else if(preScore==nowScore){
                list.get(i).rank=preRank;
            }
            if (preScore==score){
                System.out.println(preRank);
                System.exit(0);
            }

            if (nowScore==score){
                System.out.println(list.get(i).rank);
                System.exit(0);
            }

        }
        System.out.println(-1);
        System.exit(0);

    }

    static class Rank implements Comparable<Rank> {
        private int score;
        private int rank;

        public Rank(int score, int rank){
            this.score = score;
            this.rank = rank;
        }

        @Override
        public int compareTo(Rank o) {
            return o.score-this.score;
        }
    }
}
