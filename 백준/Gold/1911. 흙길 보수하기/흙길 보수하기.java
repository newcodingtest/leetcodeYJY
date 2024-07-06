import java.io.*;
import java.util.*;
public class Main {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int nulpange = Integer.parseInt(st.nextToken());

        long answer = 0;

        Queue<Point> po = new PriorityQueue<>();
        for (int i=0; i<cnt; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            po.add(new Point(start,end));
        }
        int dpEnd = 0;

        while (!po.isEmpty()){
            Point p = po.poll();
            int start = p.start;
            int end = p.end;

            if (end<dpEnd)
                continue;

            if (dpEnd<start){
                dpEnd = start;
            }

            int remain = (end-dpEnd) % nulpange;
            answer += (end-dpEnd) / nulpange;
            dpEnd = end;

            if (remain!=0){
                answer++;
                dpEnd+=nulpange-remain;
            }

        }
            System.out.println(answer);
    }

    public static class Point implements Comparable<Point> {
        private int start;
        private int end;

        public Point(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Point o) {
            if (this.start == o.start){
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}