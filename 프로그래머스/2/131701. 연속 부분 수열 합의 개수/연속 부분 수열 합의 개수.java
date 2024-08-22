import java.util.*;
class Solution {
    static Set<Integer> set = new TreeSet<>();
     public static int solution(int[] elements) {

        for (int i=1; i<=elements.length; i++){
            for (int j=0; j<elements.length; j++){
                int sum = 0;
                for (int k=j; k<j+i; k++){
                    sum+=elements[k%elements.length];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}