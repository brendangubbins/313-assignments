class Node {
    private int data;
    private Node next;

    Node(int data){
        this.data = data;
        next = null;
    }

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
    
    public int getData(){
        return data;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}