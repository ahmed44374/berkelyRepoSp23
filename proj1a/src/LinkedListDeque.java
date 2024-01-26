import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque<T> implements Deque<T> {

    public int size = 0;

    /** The basic node for the Deque. */
    public class StuffNode {
        T value;
        StuffNode next;
        StuffNode prev;

        StuffNode(T v, StuffNode n, StuffNode p)  {
            value = v;
            next = n;
            prev = p;
        }
    }

    public static void main(String[] args) {
        Deque<Integer> lld = new LinkedListDeque<>();
    }

    StuffNode sentinel = new StuffNode(null,null,null);

    public LinkedListDeque() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    @Override
    public void addFirst(T x) {
        StuffNode newNode = new StuffNode(x, sentinel.next, sentinel);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    @Override
    public void addLast(T x) {
        StuffNode newNode = new StuffNode(x,sentinel,sentinel.prev);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        StuffNode p = sentinel;
        while(p.next != sentinel) {
            returnList.add(p.next.value);
            p = p.next;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if(isEmpty()) return null;
        StuffNode newFirst = sentinel.next.next;
        sentinel.next = newFirst;
        newFirst.prev.next = null;
        newFirst.prev = sentinel;
        if(isEmpty()) return null;
        return newFirst.value;
    }

    @Override
    public T removeLast() {
        if(isEmpty()) return null;
        StuffNode newEnd = sentinel.prev.prev;
        newEnd.next.prev = null;
        newEnd.next = sentinel;
        sentinel.prev = newEnd;
        if(isEmpty()) return null;
        return newEnd.value;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size) return null;
        StuffNode p = sentinel;
        index++;
        while(index-- > 0) {
            p = p.next;
        }
        return p.value;
    }
    /** Helper method to get the element using recursion */
    private T getRecursiveHelper(int i,StuffNode p) {
        if(i == 0) return p.value;

        return getRecursiveHelper(i-1,p.next);
    }
    @Override
    public T getRecursive(int index) {
        if(index < 0 || index >= size) return null;
        return getRecursiveHelper(index+1,sentinel);
    }
}