public interface Bag<T> {
    int getCurrentSize();
    boolean isEmpty();
    boolean addNewEntry(T newEntry);
    T remove();
    boolean remove(T anEntry);
    void clear();// Clear the bag
    int getFrequencyOf(T anEntry);
    boolean contains(T anEntry);
    T[] toArray();
}
