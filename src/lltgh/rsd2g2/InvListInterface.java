package lltgh.rsd2g2;

public interface InvListInterface<T> {
    public void add(T item);
    //boolean add(int index, T item);
    public boolean contains(T item);
    public boolean update(int index, T newEntry);
    public T remove(int index);
    public int size();
    public boolean isEmpty();
    public T get(int index);
}