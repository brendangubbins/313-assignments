import java.util.List;

interface QueueInterface{
    /*
    Method returns the size of the queue(.25 point)
    */
    public int size();

    /*
    Method returns whether the queue is empty(.25 point)
    */
    public boolean isEmpty();

    /*
    Method returns a list of all elements in queue without removing from queue(1 point)
    */
    public List<Integer> getAllInQueue();

    /*
    Method remove the front of the queue(1 point)
    */
    public void dequeue();

    /*
    Method inserts a the given data to the queue(1 point)
    */
    public void enqueue(final int data);

    /*
    Method removes all from queue(1 point)
    */
    public void dequeueEntireQueue();

    /*
    Method returns a list of all elements in the queue in sorted order, without removing altering the original queue(1 point)
    */
    public List<Integer> sortQueue();
}
