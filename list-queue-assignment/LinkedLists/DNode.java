class DNode{
    private int data;
    private DNode next;
    private DNode prev;

    DNode(){
        data = -1;
        next = null;
        prev = null;
    }

    DNode(int data){
        this.data = data;
        next = null;
        prev = null;
    }

    public void setNext(DNode next){
        this.next = next;
    }

    public void setPrev(DNode prev){
        this.prev = prev;
    }

    public DNode getNext(){return next;}

    public DNode getPrev(){return prev;}

    public int getData(){return data;}
}