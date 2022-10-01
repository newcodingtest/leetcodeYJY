package 프로그래머스.level2;

import java.util.ArrayList;
import java.util.List;

public class TEST {
    private static int waitTime = 0;

    public static void main(String[] args){
        List<String> list1 = test();
        execute(list1);

  
    }


    public static List<String> test(){
        List<String> list = new ArrayList<String>();
   
        return list;
    }

    public static void execute(List<String> list1){
        if(list1.size()==0) {
            waitTime++;
            try {
                Thread.sleep(1000*waitTime);
                System.out.println((1000*waitTime)/1000 +"초 기다린다");
            } catch (Exception e) {
                // TODO: handle exception
            }

            execute(list1);

        }else{
            waitTime = 0;
            System.out.println("완료");
        }
    }

}
