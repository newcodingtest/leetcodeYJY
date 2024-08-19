import java.util.*;
class Solution {
    static int[] alpabet = new int[26];
    public static int[] solution(String s) {
        Arrays.fill(alpabet, -1);

        List<Integer> list = new ArrayList<>();

        //1 ≤ s의 길이 ≤ 10,000
        for (int i=0; i<s.length(); i++){
            //이전의 값이 있다면?
            if (alpabet[s.charAt(i)-'a']>-1){
                list.add(i-alpabet[s.charAt(i)-'a']);
            } else {
                list.add(-1);
            }
            alpabet[s.charAt(i)-'a'] = i;
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}