package 백준.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;


public class Boj6996_애너그램 {
    static HashMap<Character, Integer> map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Anagram(br.readLine());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    public static void Anagram(String input) {
        String[] arr = input.split(" ");
        String tmp1 = arr[0];
        String tmp2 = arr[1];

        if (check(tmp1, tmp2)) {
            sb.append(tmp1 + " & " + tmp2 + " are anagrams.\n");
        } else {
            sb.append(tmp1 + " & " + tmp2 + " are NOT anagrams.\n");
        }
    }

    public static boolean check(String input1, String input2) {
        map = new HashMap<Character, Integer>();
        for (char str : input2.toCharArray()) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (char str : input1.toCharArray()) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (char str : map.keySet()) {
            if (map.get(str) == 1) {
                return false;
            }
        }
        return true;
    }
}