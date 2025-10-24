import java.util.Arrays;

public class LinkedListBag<T> implements Bag<T> {
    private MyNode<T> head;  // Head node of the linked list
    private int size;        // Size of the bag

    public LinkedListBag() {
        head = null;
        size = 0;
    }

    @Override
    public int getCurrentSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean addNewEntry(T newEntry) {
        MyNode<T> newNode = new MyNode<>(newEntry);
        newNode.setNext(head);
        head = newNode;
        size++;
        return true;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        }

        T removedData = head.getData();
        head = head.getNext();  // Move head to the next node
        size--;
        return removedData;
    }

    @Override
    public boolean remove(T anEntry) {
        if (isEmpty()) {
            return false;
        }

        // Check if the first node has the item
        if (head.getData().equals(anEntry)) {
            head = head.getNext();
            size--;
            return true;
        }

        // Search for the item in the rest of the list
        MyNode<T> currentNode = head;
        while (currentNode.getNext() != null) {
            if (currentNode.getNext().getData().equals(anEntry)) {
                currentNode.setNext(currentNode.getNext().getNext());
                size--;
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;  // Item not found
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        MyNode<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getData().equals(anEntry)) {
                frequency++;
            }
            currentNode = currentNode.getNext();
        }
        return frequency;
    }

    @Override
    public boolean contains(T anEntry) {
        MyNode<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getData().equals(anEntry)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    @Override
    public T[] toArray() {
        T[] array = (T[]) new Object[size];  // Create an array of the correct size
        MyNode<T> currentNode = head;
        int index = 0;
        while (currentNode != null) {
            array[index] = currentNode.getData();
            index++;
            currentNode = currentNode.getNext();
        }
        return array;
    }
}