package 프로그래머스.level2;

import java.util.*;
import java.util.Map.Entry;

public class 메뉴리뉴얼 {
    static HashMap<String,Integer>map;
    public static void main(String[] args){
        String[] order1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course1 = {2,3,4};

        String[] order2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course2 = {2,3,5};

        String[] order3 = {"XYZ", "XWY", "WXA"};
        int[] course3 = {2,3,4};

        solution(order1,course1).forEach(x -> {
            System.out.println("x = " + x);
        });
    }

    public static ArrayList<String> solution(String[] orders, int[] course) {
        //조합 결과 배열
        ArrayList<String> answer = new ArrayList<>();

        //정렬
        for(int i=0; i<orders.length; i++){
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }

        //개수별 조합 경우의수 구하기
        for (int i=0; i<course.length; i++){
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;
                for(int j=0; j<orders.length; j++){
                    StringBuilder sb = new StringBuilder();
                    //코스보다 조합길이가 길때만
                    if(course[i]<=orders[j].length()) {
                        combi(orders[j], sb, 0,0,course[i]);
                    }
                }//for j

            //최대 값 저장=> 추후 최대값이 2를 넘어야하기 때문에
            for (Entry<String, Integer> repeated : map.entrySet()){
                max = Math.max(max, repeated.getValue());
            }
            for (Entry<String, Integer> repeated : map.entrySet()){
                if(max>=2 && repeated.getValue()==max){
                    answer.add(repeated.getKey());
                }
            }
        }//for i
        //추가된 조합들을 오름차순 정렬
        Collections.sort(answer);
        return answer;
    }

    //조합 메서드 - 백트래킹 사용
    public static void combi(String combi, StringBuilder sb, int start, int deep, int targetDeep){
        //목표 자리수 달성시 루프 탈출
        if(deep == targetDeep){
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
            return;
        }

        //조합시작
        for(int i=start; i<combi.length(); i++){
            //조합추가
            sb.append(combi.charAt(i));
            //백트래킹
            combi(combi, sb, i+1,deep+1,targetDeep);
            //초기화
            sb.delete(deep,deep+1);
        }
    }
}
