import java.util.HashSet;
import java.util.Set;

class Solution {
        private static Set<String> used = new HashSet<>();
    public static int[] solution(int n, String[] words) {
        used.add(words[0]);

        String pre = words[0];
        int num = 0;
        int order = 0;
        for (int i=1; i<words.length; i++){
            if (!words[i].startsWith(pre.substring(pre.length()-1)) ||
                used.contains(words[i])){
                num = (i%n)+1;
                order = (i/n)+1;
                break;
            }
            pre = words[i];
            used.add(words[i]);
        }

        return new int[]{num, order};
    }
}