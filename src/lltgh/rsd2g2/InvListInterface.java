package lltgh.rsd2g2;

public interface InvListInterface<T> {
    public void add(T item);
    public T remove();
    public int size();
    public boolean isEmpty();
    public T get(int index);
}