package 프로그래머스.level1;


import java.util.Locale;

public class 신규아이디추천 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){

        String test = "...!@BaT#*._.y.abcdefghijklm";


    }

   // 아이디의 길이는 3자 이상 15자 이하여야 합니다.
   // 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
   // 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.

  /*    1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
         7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.*/
        public static String solution(String new_id) {

            String first = new_id.toLowerCase(); //1단계

            first = first.replaceAll("[^-_.a-z0-9]",""); //2단계
            first = first.replaceAll("[.]{2,}","."); //3단계
            first = first.replaceAll("^[.]|[.]$",""); //4단계

            //5단계
            if(first.length()==0){
                first+="a";
            }

            //6단계
            if(first.length()>15){
                first = first.substring(0,15);
                first = first.replaceAll("^[.]|[.]$",""); //만약이면 4단계
            }

            if(first.length()<=2){
                while (first.length()<3){
                    first+=first.charAt(first.length()-1);
                }
            }
            return first;

        }


}
