import java.util.*;
public class MinPriorityQueue<T extends Comparable<T>> {
    private int size = 0;
    private List<T> list;

    MinPriorityQueue() { list = new ArrayList<>(); }

    public int len() { return size; }
    public boolean isEmpty() { return  size == 0; }
    public void add(T byteNode) {
    }


}
