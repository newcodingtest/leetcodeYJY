package 백준.그래프검색;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node1{
    char data;
    Node1 left;
    Node1 right;

    Node1(char data){
        this.data = data;
    }
}

class Tree {
    Node1 root;

    public void createNode(char data, char leftData, char rightData){
        if(root == null){
            root = new Node1(data);

            if(leftData!='.'){
                root.left = new Node1(leftData);
            }
            if(rightData!='.'){
                root.right = new Node1(rightData);
            }else {
                searchNode(root, data, leftData, rightData);
            }
        }
    }

    public void searchNode(Node1 root, char data, char leftData, char rightData){
        if(root == null){
            return;
        }else if(root.data == data){
            if(leftData != '.'){
                root.left = new Node1(leftData);
            }

            if(rightData != '.'){
                root.right = new Node1(rightData);
            }
        }else {
            searchNode(root.left, data, leftData, rightData);
            searchNode(root.right, data, leftData, rightData);
        }
    }

    //전위 순회: 루트->좌->우
    public void preorder(Node1 root){
        System.out.print(root.data); //먼저 가운데 출력
        if (root.left!=null){ // 그 다음 왼쪽
            preorder(root.left);
        }
        if (root.right!=null){ // 마지막 오른쪽
            preorder(root.right);
        }
    }
    
    //중위순회: 좌->루트->우
    public void inorder(Node1 root){
        if(root.left!=null){ //왼쪽먼저
            inorder(root.left);
        }
        System.out.print(root.data); //그다음 중앙 출력
        if(root.right!=null){ //마지막 오른쪽
            inorder(root.right); 
        }
    }

    //후위순회: 좌->우->루트트
   public void postorder(Node1 root){
        if(root.left!=null){ //왼쪽 먼저
            postorder(root.left);
        }
       if(root.right!=null){ //그 다음 오른쪽
           postorder(root.right);
       }
       System.out.print(root.data); // 루트
    }
}
public class Boj_1991 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        for (int i=0; i<N; i++){
            char[] data;
            data = br.readLine().replaceAll(" ","").toCharArray();
            tree.createNode(data[0],data[1],data[2]);
        }
        //전위 순회
        tree.preorder(tree.root);
        System.out.println();

        //중위 순회
        tree.inorder(tree.root);
        System.out.println();

        //중위 순회
        tree.postorder(tree.root);

    }
}
