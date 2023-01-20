import java.util.*;
public class MinPriorityQueue<T extends Comparable<T>> {
    private int size = 0;
    private List<T> list;

    MinPriorityQueue() { list = new ArrayList<>(); }

    public int len() { return size; }
    public boolean isEmpty() { return  size == 0; }
    public T poll() { return poll(0); }
    public void add(T elem) {
        list.add(elem);
        bubbleUp(size);
        size++;
    }

    private T poll(int i) {
        if(size == 1) {
            size--;
            T data = list.get(0);
            list.clear();
            return data;
        }
        size--;
        T data_to_return = list.get(i);
        swap(i, size);
        list.remove(list.get(size));
        bubbleDown(i);
        return data_to_return;
    }

    private void bubbleDown(int k) {
        while(true) {
            int left = (k*2) + 1;
            int right = (k*2) + 2;
            int smallest = left;
            if(right < size) {
                if (isLess(right, left)) smallest = right;
            }
            if(smallest < size) {
                if (isLess(k, smallest)) break;
                swap(k, smallest);
                k = smallest;
            } else break;
        }
    }

    private void bubbleUp(int k) {
        int parent_index = (k-1) / 2;
        while(k > 0 && isLess(k, parent_index)) {
            swap(k, parent_index);
            k = parent_index;
            parent_index = (k-1) / 2;
        }
    }

    private boolean isLess(int i, int j) {
        T e0 = list.get(i);
        T e1 = list.get(j);

        return e0.compareTo(e1) <= 0;
    }

    private void swap(int i, int j) {
        T e_i = list.get(i);
        T e_j = list.get(j);

        list.set(i, e_j);
        list.set(j, e_i);
    }

    public String toString() {
        return list.toString();
    }
}
