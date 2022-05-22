package 백준.이분탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Boj1068_트리 {
    static List<Integer>[] list;
    static int delete;
    static int n;
    static int result =0;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n];
        String[] arr = br.readLine().split(" ");

        for (int i=0; i<n; i++){
             List<Integer> temp = new ArrayList<>();
            list[i] = temp;
        }

        int root = 0;
        for (int i=0; i<n; i++){
            if(!arr[i].equals("-1")){
                int element = Integer.parseInt(arr[i]);
                list[element].add(i);
            }else if(arr[i].equals("-1")){
                root =i;
            }
        }

        delete = Integer.parseInt(br.readLine());
        if(delete==root){
            System.out.println(0);
        }else{
            checkDelete(delete);
            System.out.println(printLeafNode(root));
        }

    }

    public static void checkDelete(int delete){
        if(list[delete].size()>0){
            int size = list[delete].size();
            while(size>0){
                checkDelete(list[delete].get(--size));
            }
        }

        for(int i=0; i<n; i++){
            if(list[i].contains(delete)){
                for(int j=0; j<list[i].size(); j++){
                    if(list[i].get(j) == delete){
                        list[i].remove(j);
                    }
                }
            }
        }
    }

    public static int printLeafNode(int node){
        Queue<Integer>q = new LinkedList<>();
        q.add(node);
        int cnt = 0;
        while(!q.isEmpty()){
            int pos = q.poll();
            if(list[pos].size()==0){
                cnt++;
                continue;
            }
            for(int element:list[pos]){
                q.add(element);
            }
        }
        return cnt;
    }
}
