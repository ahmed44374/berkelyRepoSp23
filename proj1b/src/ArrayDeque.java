import java.util.ArrayList;
import java.util.List;

public class ArrayDeque<T> implements Deque<T>{

    private T[] items = (T[]) new Object[8];
    private int size;
    private int nextFront;
    private int nextBack;
    private final int MINIMUM_CAPACITY = 8;
    public ArrayDeque() {
        nextFront = 4;
        nextBack = 5;
    }
    public static void main(String[] args) {
        Deque<Integer> ad = new ArrayDeque<>();
    }

    /** Resize the array to the new capacity. */
    private void resize(int capacity) {

    }

    /** Helper method to get the next front int the deque. */
    private int nextFront(int currFront) {
        return (currFront - 1 + items.length) % items.length;
    }

    /** Helper method to get the next back int the deque */
    private int nextBack(int currBack) {
       return (currBack + 1) % items.length;
    }

    @Override
    public void addFirst(T x) {
        if(size == items.length) {
            resize(2* items.length);
        }

        items[nextFront] = x;
        nextFront = nextFront(nextFront);
        size++;
    }

    @Override
    public void addLast(T x) {
        if(size == items.length) {
            resize(2* items.length);
        }
        items[nextBack] = x;
        nextBack = nextBack(nextBack);
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        int currF = nextBack(nextFront);
        while (currF != nextBack) {
            returnList.add(items[currF]);
            currF = nextBack(currF);
        }
        return  returnList;
    }

    @Override
    public boolean isEmpty() {
       return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }
}
