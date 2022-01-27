/*
package 백준.그래프검색.BFS그리고DFS;
import java.util.LinkedList;
import java.util.Stack;
import java.util.NoSuchElementException;

class Queue<T>{

    class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;

    public void add(T item){
        Node<T> t = new Node<T>(item);

        if(last != null){
            last.next = t;
        }
        last = t;
        if(first == null){
            first = last;
        }
    }

    public T remove(){
        if(first == null){
            throw new NoSuchElementException();
        }

        T data = first.data;
        first = first.next;

        if(first == null){
            last = null;
        }
        return data;
    }

    public T peek(){
        if(first == null){
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty(){
        return first == null;
    }
}

class Graph{
    class Node{
        int data;
        // 인접한 노드들과의 관계
        LinkedList<Node> adjacent;
        // 방문했는지 마킹
        boolean marked;

        //Node 생성자
        Node (int data){
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }

    Node[] nodes; // node들을 저장할 배열
    Graph(int size){
        nodes = new Node[size];
        for(int i=0; i<size; i++){
            nodes[i] = new Node(i);
        }
    }

    //두 노드의 관계를 저장
    void addEdge(int i1, int i2){
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        //상대방이 있는지 확인하고 없으면 추가
        if(!n1.adjacent.contains(n2)){
            n1.adjacent.add(n2);
        }
        if(!n2.adjacent.contains(n1)){
            n2.adjacent.add(n1);
        }
    }

    */
/* Stack을 이용한 DFS 구현*//*

    void dfs(){
        dfs(0);
    }
    void dfs(int index){
        Node root = nodes[index];
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        root.marked = true;
        while(!stack.isEmpty()){
            Node r = stack.pop();
            for(Node n : r.adjacent){
                if(n.marked == false){
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
    }

    */
/* 재귀 호출을 이용한 DFS 구현 *//*

    void dfsR(Node r){
        if(r==null) return;
        r.marked = true;
        visit(r);
        for(Node n : r.adjacent){
            if(n.marked == false){
                dfsR(n);
            }
        }
    }

    void dfsR(int index){
        Node r = nodes[index];
        dfsR(r);
    }
    void dfsR(){
        dfsR(0);
    }

    */
/* Queue를 이용한 BFS 구현 *//*

    void bfs(){
        bfs(0);
    }

    void bfs(int index){
        Node root = nodes[index];
        Queue<Node> queue = new Queue<>();
        queue.enqueue(root);
        root.marked = true;
        while(!queue.isEmpty()){
            Node r = queue.dequeue();
            for(Node n : r.adjacent){
                if(n.makred == false){
                    n.marked = true;
                    queue.enqueue(n);
                }
            }
            visit(r);
        }
    }

    //출력
    void visit(Node n){
        System.out.print(n.data+" ");
    }
}
*/
/*
  0
 /
1ㅡㅡ3    7
|  / | \ /
| /  |  5
2ㅡㅡ4   \
          6ㅡ8
*//*

public class Test{
    public static void main(String[] args){
        Graph g = new Graph(9);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(5,6);
        g.addEdge(5,7);
        g.addEdge(6,8);
        g.bfs();
        g.dfs();
        g.dfsR();
    }
}*/
