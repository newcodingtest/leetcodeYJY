package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj14888_연산자끼어넣기 {
    static List<Integer> list = new ArrayList<>();
    static int[] operations = new int[4]; // +, -, *, /
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }

        execute(list.get(0), 1);
        sb.append(MAX + "\n").append(MIN);
        System.out.println(sb.toString());
    }

    public static void execute(int value, int idx) {
        if (idx == N) {
            MAX = Math.max(value, MAX);
            MIN = Math.min(value, MIN);

            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operations[i] > 0) {
                operations[i]--;
                switch (i) {
                    case 0:
                        execute(value + list.get(idx), idx + 1);
                        break;
                    case 1:
                        execute(value - list.get(idx), idx + 1);
                        break;
                    case 2:
                        execute(value * list.get(idx), idx + 1);
                        break;
                    case 3:
                        execute(value / list.get(idx), idx + 1);
                        break;
                }
                //백트래킹 다른 루트 동기화 문제로 인한 복구
                operations[i]++;
            }
        }
    }
}
