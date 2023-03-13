import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


class Solution {
    static Map<Integer,Integer>answerMap = new HashMap<>();
    static int[] one = {1,2,3,4,5};
    static int[] two = {2,1,2,3,2,4,2,5};
    static int[] three = {3,3,1,1,2,2,4,4,5,5};

 public static int[] solution(int[] answers) {
        List<Integer>list = new ArrayList<>();
    addElement();
     
        for (int i=0; i<answers.length; i++){
            if(answers[i]==one[i%one.length]){
                answerMap.put(1,answerMap.getOrDefault(1,0)+1);
            }
            if(answers[i]==two[i%two.length]){
                answerMap.put(2,answerMap.getOrDefault(2,0)+1);
            }
            if(answers[i]==three[i%three.length]){
                answerMap.put(3,answerMap.getOrDefault(3,0)+1);
            }
        }
        
        int[] priority = answerMap.entrySet()
                .stream()
                .sorted((e1,e2)->e2.getValue().compareTo(e1.getValue()))
                .mapToInt(i -> i.getKey())
                .toArray();
    
       for (int i=0; i<priority.length; i++){
            if(answerMap.get(priority[0]).equals(answerMap.get(priority[i]))){
                list.add(priority[i]);
            }
        }
        
        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }
    
        public static void addElement(){
        answerMap.put(1,0);
        answerMap.put(2,0);
        answerMap.put(3,0);
    }
}