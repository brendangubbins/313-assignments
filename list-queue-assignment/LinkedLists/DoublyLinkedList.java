class DoublyLinkedList implements LinkedListInterface {
    private DNode header, trailer;
    private int size;

    DoublyLinkedList(){
        header = new DNode();
        trailer = new DNode();
        header.setNext(trailer);
        trailer.setPrev(header);
        size = 0;
    }

    public void addFirst(int data){
        DNode newNode = new DNode(data);
        addAfter( newNode, header);
        size++;
    }

    private void addAfter( DNode newData, DNode after){
        after.getNext().setPrev(newData);
        newData.setNext(after.getNext());
        after.setNext(newData);
        newData.setPrev(after);
    }

    /*
    Method to insert into the back of linklist
    Param data: the integer that is being inserted
    */
    public void addLast(int data) {
        // TODO:implement method (.5 point)

        DNode newNode = new DNode(data);
        addBefore(newNode,trailer);
        size++;
    }

    /*
    Method to insert data before a given target
    If target does not exist, default to insertion of data at rear
    Param data: the integer that is being inserted
    param before: the integer we want to insert the new data before
    */
    private void addBefore (DNode data, DNode before) {
        // TODO:implement method (.5 point)

        before.getPrev().setNext(data);
        data.setPrev(before.getPrev());
        before.setPrev(data);
        data.setNext(before);
    }

    public void addAfter(int data, int after){
        DNode newData = new DNode(data);
        DNode afterNode = findNode(after);
        if(afterNode == trailer) {
            System.out.println("After node does not exist, defaulting insertion at rear");
            addBefore(newData, trailer);
            size++;
            return;
        }
        addAfter(newData, afterNode);
        size ++;
        return;
    }

    /*
    Method to insert data before a given target
    If target does not exist, default to insertion of data at rear
    Param data: the integer that is being inserted
    param before: the integer we want to insert the new data before
    */
    public void addBefore(int data, int before){
        // TODO:implement method (.5 point)

        DNode newData = new DNode(data);
        DNode beforeNode = findNode(before);

        if(beforeNode == trailer){
          System.out.println("Before node does not exist, default to insert at rear");
          addBefore(newData,trailer);
          size++;
          return; // return is important so it doesn't execute the remaining code
        }

        addBefore(newData,beforeNode);
        size++;
        return;
    }

    private DNode findNode(int target){
        DNode targetNode = header.getNext();
        while(targetNode != trailer && targetNode.getData()!=target){
            targetNode = targetNode.getNext();
        }
        return targetNode;
    }

    /*
    Method that checks to see if a given target value is in the list
    Returns true is it exist
    Returns false otherwise
    Param target: the integer we want to find in the list
     */
    public boolean contains(int target){
        // TODO:implement method (.5 point)

        return findNode(target) != trailer; // if the target reaches the trailer, the node is not found
    }

    /*
    Method that returns the node from the given index
    Return the int stored at the index provided
    If index is not in the list throw a IndexOutOfBounds Exception
    Param index: the position the user wants the data for
    */
    public int get(int index) throws Exception{
        // TODO:implement method (.5 point)

        if (index > size-1 || index < 0){
          throw new Exception(index + " is not a valid index.");
        }

        if (index > size/2){
          DNode i = trailer.getPrev();
          int tracker = size-1;
          while(tracker != index){
            i = i.getPrev();
            tracker--;
          }
          return i.getData();
        }

        DNode i = header.getNext();
        int tracker = 0;
        while(tracker != index){
          i = i.getNext();
          tracker++;
        }
        return i.getData();
    }

    /*
    Method removes the head node from the list
    */
    public void removeHead(){
        // TODO:implement method (.5 point)

        if (size < 1){ // empty list, do nothing
          return;
        }

        if (size == 1){ // one element, so attach header and trailer to each other
          header.setNext(trailer);
          trailer.setPrev(header);
          size--;
          return;
        }

        DNode removal = header.getNext();
        removal.getNext().setPrev(header);
        header.setNext(removal.getNext());
        size--;
    }

    /*
    Method for testing purposes

    public void printList(){
      System.out.println("Left to Right");
      for (DNode i = header.getNext(); i != trailer; i = i.getNext()){
        System.out.print(i.getData() + " ");
      }
      System.out.print("(Size: " + size + ")");

      System.out.println();
      System.out.println();

      System.out.println("Right to Left");
      for (DNode i = trailer.getPrev(); i != header; i = i.getPrev()){
        System.out.print(i.getData() + " ");
      }
      System.out.print("(Size: " + size + ")");

      System.out.println();
      System.out.println();
    }

    */
}
