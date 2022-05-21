package 프로그래머스.level1;

public class 키패드누르기    {

    //좌표 구하는법
    //x (키패드-1)/3;
    //y (키패드-1)%3;

    //0일땐

    //왼쪽손은 *(10) 오른쪽손은 #(12) 가 디폴트 위치

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";
        System.out.println(solution(test,hand));

    }

    public static String solution(int[] numbers, String hand){
        //왼쪽손은 *(10) 오른쪽손은 #(12) 가 디폴트 위치
        int tempRight = 12;
        int tempLeft = 10;

        for (int i=0; i<numbers.length; i++){
            int temp = numbers[i];
                //윈쪽 오른쪽 라인인 경우
                if(isRight(temp)){
                    sb.append('R');
                    tempRight = temp;
                }else if(isLeft(temp)){
                    sb.append('L');
                    tempLeft = temp;
                }
                //중간 라인 경우
                else{

                    //최근 오른쪽, 왼쪽 좌표값 비교를 통해 짧은 쪽을 택한다.

                    int right = cal(temp,tempRight);
                    int left  = cal(temp,tempLeft);

                    if(right>left){
                        tempLeft=temp;
                        sb.append("L");
                    }else if(right<left){
                        tempRight=temp;
                        sb.append("R");
                    }else{
                        if(hand.equals("right")){
                            tempRight=temp;
                            sb.append("R");
                        }else if(hand.equals("left")){
                            tempLeft=temp   ;
                            sb.append("L");
                    }
                }
            }
        }

        return sb.toString();
    }


    public static boolean isRight(int element){

        if(element%3==0 && element!=0){
            return true;
        }
        return false;
    }

    public static boolean isLeft(int element){
        if(element%3==1){
            return true;
        }
        return false;
    }
    //좌표 구하는법
    //x (키패드-1)/3;
    //y (키패드-1)%3;
    public static int cal(int middle, int location){

        int middleTemp = middle;
        if(middleTemp==0){
            middleTemp=11;
        }

        if(location==0){
            location=11;
        }


        int mx = middleTemp/3;
        int my = 1;

        int lx = (location-1)/3;
        int ly = (location-1)%3;

         return Math.abs(mx-lx) + Math.abs(my-ly);

    }




}
