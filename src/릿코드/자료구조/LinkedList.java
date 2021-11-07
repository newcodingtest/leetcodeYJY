package 릿코드.자료구조;

class LinkedList {
    Node head;
    Node tail;
    int count;

    public LinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        count = 0;
    }

    //등로
    public int get(int index) {
        if(index < 0 || index >= count){
            return -1;
        }
        Node curr = head.next;
        int idx = 0;
        while(idx < index){
            idx++;
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
        count++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev.next = newNode;
        tail.prev = newNode;
        count++;
    }

    public void addAtIndex(int index, int val) {
        if(index<0 || index>count){
            return;
        }
        if(index==0){
            addAtHead(val);
        }
        else if(index == count){
            addAtTail(val);
        }
        else{
            int idx = 0;
            Node curr = head;
            while(idx < index){
                idx++;
                curr = curr.next;
            }
            Node newNode = new Node(val);
            newNode.prev = curr;
            newNode.next = curr.next;
            curr.next.prev = newNode;
            curr.next = newNode;
            count++;
        }
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= count){
            return;
        }
        int idx = 0;
        Node curr = head;
        while(idx < index){
            idx++;
            curr = curr.next;
        }
        Node next = curr.next.next;
        next.prev = curr;
        curr.next = next;
        count--;
    }
}

class Node{
    int val; //데이터 저장
    Node next; //다음 요소의 주소
    Node prev; //이전 요소의 주소

    public Node(int val){
        this.val = val;
        next = null;
        prev = null;
    }
}

