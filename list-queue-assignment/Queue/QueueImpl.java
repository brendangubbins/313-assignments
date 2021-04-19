/*
This queue must not be bounded by a capacity!
You can ONLY use the following methods without penalty from the List interface:
    - https://docs.oracle.com/javase/8/docs/api/java/util/List.html#add-E-
    - https://docs.oracle.com/javase/8/docs/api/java/util/List.html#get-int-
    - https://docs.oracle.com/javase/8/docs/api/java/util/List.html#remove-int-
Any usage of other methods will result in a one point duction per use.
    Example if you use the .sort() method twice, you will lose 2 points
    or if you use .clear() and .isEmpty(), you will lose 2 points
*/

import java.util.List;
import java.util.LinkedList;
//import java.util.ArrayList; // ArrayList has a hidden capacity, not legal for this assignment

public class QueueImpl implements QueueInterface{
    private List<Integer> queue;
    private int size;

    public QueueImpl(){
      queue = new LinkedList<>();
      size = 0;
    }

    //This constructor builds the queue with the elements in initalMembers
    public QueueImpl(final List<Integer> initialMembers){
      size = 0;
      for (Integer data : initialMembers){ // enhanced loop to iterate through the given list
        size++; // making sure the size of  the queue matches the size of the argument list
      }
      queue = initialMembers;
    }

    public int size(){
      return size;
    }

    public boolean isEmpty(){
      return size == 0;
    }

    public List<Integer> getAllInQueue(){
      List<Integer> copy = new LinkedList<>(queue);
      return copy;
    }

    public void dequeue(){
      if (size > 0){ // attempting to dequeue an empty list will result in an IndexOutOfBounds exception
        queue.remove(0);
        size--;
      }
      return;
    }

    public void enqueue(final int data){
      queue.add(data);
      size++;
    }

    public void dequeueEntireQueue(){
      while (size != 0){ // dequeues as long as there are elements remaining
        dequeue();
      }
    }

    public List<Integer> sortQueue(){
      int n = size;
      List<Integer> copy = new LinkedList<>(queue); // in order to not alter the original queue, a copy is made

      for (int i = 1; i < n; i++){ // insertion sort
        int target = copy.get(i);
        int j = i-1;
        while (j > -1 && copy.get(j) > target){
          copy.set(j+1, copy.get(j));
          j--;
        }
        copy.set(j+1, target);
      }

      return copy;
    }

    /*public List<Integer> sortQueue(){ // tested merge sort instead of insertion sort
      int n = size;
      List<Integer> copy = new LinkedList<>(queue);
      int low = 0;
      int high = n-1;
      mergeSort(copy,low,high);
      return copy;
    }

    public void mergeSort(List<Integer> unsortedList, int low, int high){
      if (low < high){
        int mid = (low + high)/2;
        mergeSort(unsortedList, low, mid);
        mergeSort(unsortedList, mid+1, high);
        merge(unsortedList, low, mid, high);
      }
    }

    public void merge(List<Integer> unsortedList, int left, int mid, int right){
      int n1 = mid-left+1;
      int n2 = right-mid;
      int Left[] = new int[n1];
      int Right[] = new int[n2];

      for (int i = 0; i < n1; ++i){ // ++i
        Left[i] = unsortedList.get(left + i);
      }
      for (int j = 0; j < n2; ++j){ // ++j
        Right[j] = unsortedList.get(mid + 1 + j);
      }

      int i = 0, j = 0, k = left;
      while (i < n1 && j < n2){
        if (Left[i] <= Right[j]){
          unsortedList.set(k, Left[i]);
          i++;
        }
        else{
          unsortedList.set(k, Right[j]);
          j++;
        }
        k++;
      }
      while (i < n1){
        unsortedList.set(k, Left[i]);
        i++;
        k++;
      }
      while (j < n2){
        unsortedList.set(k, Right[j]);
        j++;
        k++;
      }
    }
    */
}
