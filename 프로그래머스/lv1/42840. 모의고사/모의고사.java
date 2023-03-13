import java.util.*;



class Solution {
 static int[] pattern_1 = {1,2,3,4,5};
    static int[] pattern_2 = {2,1,2,3,2,4,2,5};
    static int[] pattern_3 = {3,3,1,1,2,2,4,4,5,5};
    static List<Integer> result = new ArrayList<>();
    static Map<Integer,Integer> rank = new LinkedHashMap<>();

    public static int[] solution(int[] answers) {
        int len = answers.length;
        rank.put(1,0);
        rank.put(2,0);
        rank.put(3,0);

        for (int i=0; i<len; i++){
            if(answers[i]==pattern_1[i%pattern_1.length]){
                int value = rank.get(1);
                rank.put(1,value+1);
            }
            if(answers[i]==pattern_2[i%pattern_2.length]){
                int value = rank.get(2);
                rank.put(2,value+1);
            }
            if(answers[i]==pattern_3[i%pattern_3.length]){
                int value = rank.get(3);
                rank.put(3,value+1);
            }
        }

        int max = 0;
        for (Map.Entry entry: rank.entrySet()){
           int temp = (int)entry.getValue();
            System.out.println(temp);
            if(max<temp){
               max = temp;
           }
        }

        for (Map.Entry entry: rank.entrySet()){
            int temp = (int)entry.getValue();
            if(max==temp){
                result.add((int)entry.getKey());
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}